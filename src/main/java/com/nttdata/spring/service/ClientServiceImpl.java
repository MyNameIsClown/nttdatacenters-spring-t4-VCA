package com.nttdata.spring.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nttdata.spring.models.Client;
import com.nttdata.spring.repository.ClientRepository;

/**
 * Client Service Implementation
 * 
 * @author Victor Carrasco
 *
 */
@Service("ClientService")
@Primary
public class ClientServiceImpl implements ClientServiceI{
	@Autowired
	ClientRepository repository;

	@Override
	public Client findByNombreCompleto(String nombre, String apellidos) {
		return repository.findClientDistinctByNombreAndApellidos(nombre, apellidos);
	}

	@Override
	public void addClient(String nombre, String apellidos, String dni, Date fechaNacimiento) {
		Client newClient = new Client();
		newClient.setNombre(nombre);
		newClient.setApellidos(apellidos);
		newClient.setDni(dni);
		newClient.setFechaDeNacimiento(fechaNacimiento);
		repository.save(newClient);
	}

	@Override
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	
}
