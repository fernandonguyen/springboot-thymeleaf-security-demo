package com.codegym.springbootthymeleafsecuritydemo.controller;

import com.codegym.springbootthymeleafsecuritydemo.entities.Student;
import com.codegym.springbootthymeleafsecuritydemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/students/")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("signup")
    public String showSignUpForm(Student student) {
        return "student/add-student";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "student/list-student";
    }

    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "student/add-student";
        }

        studentRepository.save(student);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "student/update-student";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "student/update-student";
        }

        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "student/list-student";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        model.addAttribute("students", studentRepository.findAll());
        return "student/list-student";
    }
}
