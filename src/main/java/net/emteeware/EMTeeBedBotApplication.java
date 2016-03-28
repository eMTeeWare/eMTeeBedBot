package net.emteeware;

import lombok.extern.slf4j.Slf4j;
import net.emteeware.service.EmteeBedBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EMTeeBedBotApplication implements CommandLineRunner {

    @Autowired
    EmteeBedBotService emteeBedBotService;

	public static void main(String[] args) {
        log.info("main method");
        SpringApplication.run(EMTeeBedBotApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception
    {
        log.info("run method");
        emteeBedBotService.runMainLoop();
    }
}
