package com.Beginner.RestApi.Controller;

import com.Beginner.RestApi.entity.Course;
import com.Beginner.RestApi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public  String Hello()
    {
        return "<h1>this is the home page</h1>";
    }

    @GetMapping("/Courses")
    public ArrayList<Course> getAllCourses()
    {
        return this.courseService.getAllCourses();
    }

    @GetMapping("/Courses/{CourseId}")
    public Course getCourseByID(@PathVariable String CourseId)
    {
        return this.courseService.getCourseById(Long.parseLong(CourseId));
    }

    @PostMapping("/Courses/addCourse")
    public String addCourse(long id, String name, String description)
    {
        return this.courseService.addCourse(id,name,description);
    }
}
