package QuDi1.QuDi;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MyAppclition {
	@RequestMapping("/test")
	public String test() {
		return "hello word";
	}

	
}
