package com.nttdata.spring.service;

import java.sql.Date;
import java.util.List;

import com.nttdata.spring.models.Client;
/**
 * Client Service Interface
 * 
 * @author Victor Carrasco
 *
 */
public interface ClientServiceI {
	/**
	 * Busca un cliente en base de datos por nombre y apellidos
	 * @param nombre
	 * @param apellidos
	 * @return
	 */
	public Client findByNombreCompleto(String nombre, String apellidos);
	
	/**
	 * Añade un cliente a la bbdd
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param fechaNacimiento
	 */
	public void addClient(String nombre, String apellidos, String dni, Date fechaNacimiento);
	
	/**
	 * Lista todos los clientes
	 * 
	 * @return
	 */
	public List<Client> findAll();
}
