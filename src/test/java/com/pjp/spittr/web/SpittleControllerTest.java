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
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 *
 * @author pjaraba
 */
public class SpittleControllerTest {
    @Test
    public void shouldShowRecentSpittles() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepo = mock(SpittleRepository.class);
        String spittleViewName = "spittles";
        
        // when the someone calls the method "findSpittles" from the repo, return "expectedSpittles"
        when(mockRepo.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);
        
        SpittleController controller = new SpittleController(mockRepo);
        
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView(getJspViewPath(spittleViewName)))
                .build();
        
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name(spittleViewName))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }
    
    @Test
    public void shouldShowPagesSpittles() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepo = mock(SpittleRepository.class);
        String spittleViewName = "spittles";
        
        when(mockRepo.findSpittles(238900, 50))
                .thenReturn(expectedSpittles);
        
        SpittleController controller = new SpittleController(mockRepo);
        
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView(getJspViewPath(spittleViewName)))
                .build();
        
        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name(spittleViewName))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
        
    }
    
    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepo = mock(SpittleRepository.class);
        
        when(mockRepo.findOne(12345))
                .thenReturn(expectedSpittle);
        
        SpittleController controller = new SpittleController(mockRepo);
        
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
        
    }
    
    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
