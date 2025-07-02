package com.Beginner.RestApi.service;

import com.Beginner.RestApi.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseServiceImplementation implements  CourseService {

    ArrayList<Course> courses;

    public CourseServiceImplementation() {
        this.courses = new ArrayList<Course>();
        Course a =   new Course("English Couse","English",1);
        Course b =   new Course("Data  structure and algorithm Couse","DSA",2);
        Course c =   new Course("Computer architecture and design","COA",3);
        courses.add(a);
        courses.add(b);
        courses.add(c);
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    @Override
    public Course getCourseById(long courseId)
    {
       for(Course c:courses)
       {
           if(c.getId() == courseId)
           {
               return c;
           }
       }
        return null;
    }

    @Override
    public String addCourse(long id, String name, String description) {
        String message="";
        try {
            this.courses.add(new Course(name,description,id));
            message="Course added successfully";
        }
        catch (Exception e)
        {
            message = e.getMessage();
        }
        return message;
    }


}
