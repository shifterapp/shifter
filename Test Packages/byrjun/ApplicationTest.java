package byrjun;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
/**
 *
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 * 
 * Prófunarklasi sem framkvæmir prófanir án þess að þurfa að kalla á þjóninn 
*/

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc       // Spring MockMvc - allt "context"-ið keyrt upp 
public class ApplicationTest {
    
        // Þjónninn (Tomcat) ekki keyrður upp 
        @Autowired
        private MockMvc mockMvc;
         
        /**
         * Aðferð til að athuga hvort virkar að senda HttpRequest á /employeeList
         * og fá til baka allEmployees.jsp síðuna sem inniheldur strenginn Employee
         */
	@Test 
        public void employeeListSkilarName() throws Exception {
        this.mockMvc.perform(get("/employeeList"))                
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Name")));
    }
	
		/**
	     * Aðferð til að athuga hvort virkar að senda HttpRequest á /employeeList
	     * og fá til baka allEmployees.jsp síðuna sem inniheldur strenginn Employee
	     */
	@Test 
	    public void shiftListSkilarTitle() throws Exception {
	    this.mockMvc.perform(get("/shiftList"))                
	            .andDo(print()).andExpect(status().isOk())
	            .andExpect(content().string(containsString("Vakt1")));
}

}
