package com.Beginner.RestApi.Controller;

import com.Beginner.RestApi.entity.Course;
import com.Beginner.RestApi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/course")
    public ArrayList<Course> getAllCourses()
    {
        return this.courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable long id) {
        try {
            Course course = courseService.getCourseById(id);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/course/addCourse")
    public String addCourse(long id, String name, String description)
    {
        return this.courseService.addCourse(id,name,description);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable long id, @RequestBody Course updatedCourse) {
        try {
            Course course = courseService.updateCourse(id, updatedCourse.getName(),updatedCourse.getDescription());
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long id)
    {
        try{
           String ans =  this.courseService.deleteCourse(id);
           return ResponseEntity.ok(ans);
        }
        catch (Exception e)
        {
           String ans = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ans);
        }
    }
}
