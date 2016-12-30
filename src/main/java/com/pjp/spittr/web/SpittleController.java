/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.spittr.web;

import com.pjp.spittr.Spittle;
import com.pjp.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pjaraba
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    
    private static final String MAX_LONG_AS_STRING = ""+Long.MAX_VALUE;
    
    private SpittleRepository spittleRepository;
    
    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String spittles(@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max, 
                           @RequestParam(value="count", defaultValue="20") int count, 
                           Model model){
        model.addAttribute("spittleList",spittleRepository.findSpittles(max, count));
        return "spittles";
    }
    
    @RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId,
                           Model model){
        model.addAttribute("spittle",spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
