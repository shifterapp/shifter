package byrjun;

import byrjun.controller.*;
import byrjun.services.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

// Athugið vel að þessi import séu rétt 
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;

import static org.mockito.Mockito.when;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

/**
*
* @author Markús Freyr Sigurbjörnsson
* @date október 2017 
* HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
* 
* Prófunarklasi sem framkvæmir prófanir á weblayer og notar WebMvcTest og
* Mockito til að prófa service klasa 
*/

@RunWith(SpringRunner.class)

@WebMvcTest(EmployeeController.class) 
@ImportAutoConfiguration(ThymeleafAutoConfiguration.class)

public class WebMockJava {
	
    // Þjónninn (Tomcat) ekki keyrður upp 
    @Autowired
    private MockMvc mockMvc;
    
    // Bætum við prófunar (e. Mock) service klasa - kemur úr springframework safninu (fyrir Mockito
    // sérstaklega gert fyrir Mockito safnið 
    @MockBean
    EmployeeService employeeService;
    
 
    
    @Test
    public void testaLifirTrue() throws Exception {

        when(employeeService.nameOnCorrectForm("maggi dawg")).thenReturn(true);
        this.mockMvc.perform(get("/employeeList"))
                .andDo(print())
                .andExpect(status()
                .isOk())
                .andExpect(content()
                .string(containsString("Starfsmannalisti")));  
      
    }    
    
    
    
    

}
