package ar.edu.unju.fi.tp3.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp3.model.Cliente;
import ar.edu.unju.fi.tp3.service.IClientesService;
import ar.edu.unju.fi.tp3.util.TablaCliente;

@Service("ClienteRamImp")
public class ClienteServiceImp implements IClientesService {

	private List<Cliente> clientes = TablaCliente.clientes;
	
	
	
	
	public ClienteServiceImp() {
		this.generarListaCliente();
	}

	@Override
	public void addClinte(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> getCliente() {
		// TODO Auto-generated method stub
		return this.clientes;
	}

	@Override
	public void generarListaCliente() {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente("DNI", 27228422, "Flores", "Eduardo", "raeduflo33@gmail.com", "12345", LocalDate.of(1979,11,11), 388, 154122470, LocalDate.of(2021, 03, 12));
		clientes.add(cliente);
	}
	
	

}
