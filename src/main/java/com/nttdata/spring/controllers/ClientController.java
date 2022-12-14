package com.nttdata.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.spring.models.Client;
import com.nttdata.spring.service.ClientServiceI;
/**
 * Client controller
 * 
 * @author Victor Carrasco
 *
 */
@Controller
@RequestMapping("/clientes/")
public class ClientController {
	@Autowired
	ClientServiceI service;
	
	/**
	 * Muestra todos los clientes
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("mostrarClientes")
	public String mostrarClientes(Model model) {
		model.addAttribute("clientes", service.findAll());
		return "Forms/mostrarClientes";
	}
	
	/**
	 * abre el html que contiene el formulario para añadir clientes
	 * 
	 * @return
	 */
	@RequestMapping("añadirClientes")
	public String addClientes() {
		return "Forms/añadirClientes";
		
	}
	
	/**
	 * abre el html que contiene el formulario de la consulta
	 * 
	 * @return
	 */
	@RequestMapping("consultarClientes")
	public String consultarClientes() {
		return "Forms/consultarClientes";
		
	}
	
	/**
	 * Añade el cliente y abre la pagina inicial
	 * 
	 * @param newClient
	 * @return
	 */
	@PostMapping("/añadirClientes/addCliente")
	public String addClient(@ModelAttribute("cliente") Client newClient) {
		service.addClient(newClient);
		
		return "index";
	}
	
	/**
	 * lista los clientes por nombre y apellido
	 * 
	 * @param model
	 * @param nombre
	 * @param apellidos
	 * @return
	 */
	@RequestMapping("/consultarClientes/filtraClientes")
	public String filtraClientes(Model model, @RequestParam String nombre, @RequestParam String apellidos) {
		
		model.addAttribute("clientesEncontrados", service.findClientByNombreCompleto(nombre, apellidos));
		return "Forms/consultarClientes";
		
	}
	
}
