import React, { useEffect, useState } from 'react'
import axios from 'axios';


const CourseRegistration = () => {
  
    const [formData, setFormData] = useState(
        {
            name:'',
            emailId:'',
            courseName:''
        }
    );

    const [message, setMessage] = useState('');
    
    const handleChange = (e) =>{
        setFormData(prev => ({
            ...prev,
            [e.target.name]:e.target.value
        }));
    };

    const handleSubmit = async(e)=>{
       e.preventDefault(); 


        try{
            const params = new URLSearchParams(formData).toString();

            const response = await axios.post(`http://localhost:8080/Courses/register?${params}`);


            setMessage(response.data.message);

             setFormData({
            name: '',
            emailId: '',
            courseName: ''
        });
        }catch(error){
            setMessage('Error occurred while registering for the course');
            console.error('Error:', error);
        }
    }
  return (
    <div>
        <h2>Course Registration</h2>

        <form onSubmit={handleSubmit}>
            <input 
                type="text"
                name="name"
                placeholder="Your name"
                value={formData.name}
                onChange={handleChange}
                required
             />
             <br />
             <input 
                type="email"
                name="emailId"
                placeholder="Your Email"
                value={formData.emailId}
                onChange={handleChange}
                required 
            />
            <br />
            <select 
            name="courseName"
            value={formData.courseName}
            onChange={handleChange}
            required>
                <option value="" disabled>Select Course</option>
                <option value="React">React</option>
                <option value="Node">Node</option>
                <option value="Java">Java</option>
                <option value="Python">Python</option>
                <option value="JavaScript">JavaScript</option>
            </select>
            <br />
            <button type="submit">Enroll</button>
        </form>
         {message && <p>{message}</p>}
    </div>
  );
}

export default CourseRegistration