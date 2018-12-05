package io.github.ppSoftware.rpgSys.msSkills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MsSkillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSkillsApplication.class, args);
	}
}
