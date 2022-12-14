package com.nttdata.spring;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.models.Client;
import com.nttdata.spring.service.ClientServiceI;

/**
 * NTTDataMain
 * 
 * @author Victor Carrasco
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner{
	@Autowired
	ClientServiceI clientService;
	
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insercion de datos
		clientService.addClient("Juan", "Romero", "111D", Date.valueOf(LocalDate.of(2022, 11, 16)));
		clientService.addClient("Mario", "Patiño", "234R", Date.valueOf(LocalDate.of(2002, 10, 25)));
		clientService.addClient("Luis", "Vazquez", "123Q", Date.valueOf(LocalDate.of(2001, 12, 17)));
		clientService.addClient("Lola", "Carrasco", "786D", Date.valueOf(LocalDate.of(2001, 1, 11)));
		clientService.addClient("Juana", "Artacho", "984V", Date.valueOf(LocalDate.of(2000, 6, 1)));
		clientService.addClient("Paca", "Pacheco", "009E", Date.valueOf(LocalDate.of(2003, 9, 3)));
		
		Client c1 = clientService.findByNombreCompleto("Juan", "Romero");
		
		List<Client> allClients = clientService.findAll();
		
		System.out.println("Respuesta: " + c1);
		
		for(Client c: allClients) {
			System.out.println(c);
		}
	}
}
