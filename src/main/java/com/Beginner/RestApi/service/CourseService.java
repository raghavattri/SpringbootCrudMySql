package com.Beginner.RestApi.service;

import com.Beginner.RestApi.entity.Course;

import java.util.ArrayList;

public interface CourseService {

    public ArrayList<Course> getAllCourses();

    public  Course getCourseById(long courseId);

    public String addCourse(long id,String name,String description);

    public Course updateCourse(long id,String name,String description);

    public String deleteCourse(long id);
}
