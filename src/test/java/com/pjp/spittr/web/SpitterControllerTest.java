/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.spittr.web;

import com.pjp.spittr.Spitter;
import com.pjp.spittr.data.SpitterRepository;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


/**
 *
 * @author pjaraba
 */
public class SpitterControllerTest {
    
    @Test 
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepo = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("pjaraba", "pello1994", "Pedro", "Jaraba");
        Spitter saved = new Spitter(24L,"pjaraba", "pello1994", "Pedro", "Jaraba");
        
        when(mockRepo.save(unsaved))
                .thenReturn(saved);
        
        SpitterController controller = new SpitterController(mockRepo);
        
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(post("/spitter/register")
                .param("username","pjaraba")
                .param("password","pello1994")
                .param("firstName","Pedro")
                .param("lastName","Jaraba"))
                .andExpect(redirectedUrl("/spitter/pjaraba"));
        
        verify(mockRepo, atLeastOnce()).save(unsaved);
                
    }
    
}
