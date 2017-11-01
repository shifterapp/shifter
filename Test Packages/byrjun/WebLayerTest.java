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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;


/**
*
* @author Markús Freyr Sigurbjörnsson
* @date október 2017 
* HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
* 
* Prófunarklasi sem framkvæmir prófanir á weblayer og notar WebMvcTest 
*/

@RunWith(SpringRunner.class)
//@WebMvcTest (EmployeeController.class)
@WebMvcTest (ShiftController.class) 
 

public class WebLayerTest {
	
	// Þjónninn ekki keyrður upp 
    @Autowired
    private MockMvc mockMvc;
    
  //  @MockBean
 //  ShiftService EmployeeService;
    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á listiKennari
     * og fá til baka listiKennara.html síðuna 
     */
@Test 
    public void nyrKennariSkilarKarl() throws Exception {
    this.mockMvc.perform(get("/shiftList"))                
            .andDo(print()).andExpect(status().isOk())
    		.andExpect(content().string(containsString("Starfsmannalisti")));
	}	

}
