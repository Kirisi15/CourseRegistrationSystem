package com.example.Course.Registration.System.Controller;

import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Model.Users;
import com.example.Course.Registration.System.Service.CourseService;
import com.example.Course.Registration.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CourseService courseService;

    @Autowired
    UserService service;

    @GetMapping("Courses-enrolled")
    public List<CourseRegistry> enrolledStudents(){

        return courseService.enrolledStudents();
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody Users user){

        service.addUser(user);
    }

}
