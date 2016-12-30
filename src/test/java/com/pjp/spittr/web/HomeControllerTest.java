/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.spittr.web;

import com.pjp.spittr.Spittle;
import com.pjp.spittr.data.SpittleRepository;
import static com.pjp.spittr.util.Paths.getJspViewPath;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 *
 * @author pjaraba
 */
public class HomeControllerTest {
    
    public HomeControllerTest() {
    }
    
    
    /**
     * Test of home method, of class HomeController.
     * @throws java.lang.Exception
     */
    @Test
    public void testHomePage() throws Exception{
        System.out.println("home");
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        assertEquals("home", controller.home());
        
    }
    
    
    
}
