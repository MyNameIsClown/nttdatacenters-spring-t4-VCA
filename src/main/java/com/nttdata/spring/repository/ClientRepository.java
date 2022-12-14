package com.nttdata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring.models.Client;

/**
 * Client Repository extends JpaRepository
 * @author Victor Carrasco
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	/**
	 * Busca un cliente por nombre completo
	 * @param nombre
	 * @param apellidos
	 * @return
	 */
	public Client findClientDistinctByNombreAndApellidos(String nombre, String apellidos);
}
