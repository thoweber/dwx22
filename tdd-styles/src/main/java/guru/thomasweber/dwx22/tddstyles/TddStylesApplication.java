package guru.thomasweber.dwx22.tddstyles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("guru.thomasweber.dwx22.tddstyles.port.persistence.*")
@EntityScan("guru.thomasweber.dwx22.tddstyles.port.persistence.*")
public class TddStylesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TddStylesApplication.class, args);
	}

}
