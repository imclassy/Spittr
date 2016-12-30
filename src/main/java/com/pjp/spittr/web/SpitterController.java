/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.spittr.web;

import com.pjp.spittr.Spitter;
import com.pjp.spittr.data.SpitterRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author pjaraba
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    
    private SpitterRepository repo;
    
    @Autowired
    public SpitterController(SpitterRepository repo) {
        this.repo = repo;
    }
    
    @RequestMapping(value="/register", method=GET) //route for get "/spitter/register"
    public String showRegistrationForm(){
        return "registerForm";
    }
    
    @RequestMapping(value="/register", method=POST) //route for post "/spitter/register"
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        repo.save(spitter);
        if(errors.hasErrors()){
            return "registerForm";
        }
        return "redirect:/spitter/" + spitter.getUsername();
    }
    
    @RequestMapping(value="/{username}",method=GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        Spitter spitter = repo.findByUsername(username);
        model.addAttribute("spitter",spitter);
        
        return "profile";
    }

    
}
