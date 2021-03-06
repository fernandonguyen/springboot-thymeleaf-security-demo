package com.codegym.springbootthymeleafsecuritydemo.controller;

import com.codegym.springbootthymeleafsecuritydemo.entities.Message;
import com.codegym.springbootthymeleafsecuritydemo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("msgs",messageRepository.findAll());
        return "userhome";
    }

    @PostMapping("/messages")
    public String saveMessage(@Valid Message message, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "error";
        }
        messageRepository.save(message);
        return "redirect:/home";
    }
}
