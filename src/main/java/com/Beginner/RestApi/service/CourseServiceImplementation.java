package com.Beginner.RestApi.service;

import com.Beginner.RestApi.dao.CourseDao;
import com.Beginner.RestApi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements  CourseService {

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImplementation() {
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        return (ArrayList<Course>) courseDao.findAll();
    }

    @Override
    public Course getCourseById(long courseId) {
        Optional<Course> courseOptional = courseDao.findById(courseId);
        return courseOptional.orElse(null); // Return null if not found, or handle differently
    }

    @Override
    public String addCourse(long id, String name, String description) {
        String message="";
        try {
            this.courseDao.save(new Course(name,description,id));
            message="Course added successfully";
        }
        catch (Exception e)
        {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public Course updateCourse(long id, String name, String description) {

        Optional<Course> c = this.courseDao.findById(id);

        if(c.isEmpty())
        {
            throw new RuntimeException("Course not found with ID: " + id);
        }
        Course UpdatedCourse =  c.get();
        UpdatedCourse.setDescription(description);
        UpdatedCourse.setName(name);
        return this.courseDao.save(UpdatedCourse);
    }

    @Override
    public String deleteCourse(long id) {
        Optional<Course> courseOptional = courseDao.findById(id);
        if (courseOptional.isEmpty()) {
            throw new RuntimeException("Course not found with ID: " + id);
        }
        courseDao.deleteById(id);

        return "course deleted successfully";
    }


}
