package byrjun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	 private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	/**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á heimaslóðina og
     * fá til baka síðu sem inniheldur Klukkan 
    
     * @throws java.lang.Exception
     */
	@Test
	public void heimaSkilarKlukkan() throws Exception{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Starfsmannaskráning");
	}
}
