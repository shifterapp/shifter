package byrjun;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import byrjun.controller.EmployeeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	EmployeeController employeeController;
	
	@Test
	public void contextLoads(){
		assertThat(employeeController).isNotNull();
	}
	
}
