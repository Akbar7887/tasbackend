package tas.uz.tasbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tas.uz.tasbackend.service.fileupload.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class TasbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasbackendApplication.class, args);
	}

}
