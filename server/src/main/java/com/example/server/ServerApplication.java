package com.example.server;

import com.example.server.enumerattion.Status;
import com.example.server.model.Server;
import com.example.server.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepository serverRepository) {
		return args -> {
			serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC", Status.SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.56", "Windows 10", "64 GB", "OTS PC", Status.SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.112", "Windows 11", "32 GB", "Personal PC", Status.SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.34", " Mac OS", "8 GB", "Efood PC", Status.SERVER_UP));

		};
	}

}
