package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.repository.CourseRepository;
import com.example.demo.model.Course;

import org.springframework.ui.Model;


    @Controller
public class CourseController {

    @Autowired
    private CourseRepository repo;

    // Home page
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Show form
    @GetMapping("/add-courses")
    public String showForm(Model model) {
        model.addAttribute("course", new Course());
        return "add-courses";
    }

    // Save course
    @PostMapping("/save-course")
    public String saveCourse(@ModelAttribute Course course) {
        repo.save(course);
        return "redirect:/view-courses";
    }

    // View courses
    @GetMapping("/view-courses")
    public String viewCourses(Model model) {
        model.addAttribute("courses", repo.findAll());
        return "view-courses";
    }
}
    
