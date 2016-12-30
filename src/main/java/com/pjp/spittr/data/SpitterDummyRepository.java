/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.spittr.data;

import com.pjp.spittr.Spitter;
import org.springframework.stereotype.Component;

/**
 *
 * @author pjaraba
 */
@Component
public class SpitterDummyRepository implements SpitterRepository{

    @Override
    public Spitter save(Spitter spitter) {
        if(spitter.getId() == null)
            spitter.setId((long)Math.random()*100);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return new Spitter((long)Math.random()*100,username, "pass", "David", "Jaraba");
    }
    
}
