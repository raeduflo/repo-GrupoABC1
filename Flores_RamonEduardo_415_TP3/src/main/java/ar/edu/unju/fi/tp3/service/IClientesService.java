package ar.edu.unju.fi.tp3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp3.model.Cliente;

@Service
public interface IClientesService {

	public void addClinte(Cliente cliente);
	public List<Cliente> getCliente();
	public void generarListaCliente();
	
}
