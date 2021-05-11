package ar.edu.unju.fi.tp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp3.service.IClientesService;


@Controller
public class ClienteController {
    
	
	@Autowired
	@Qualifier("ClienteRamImp")
	IClientesService clienteService;
	
	@GetMapping("/cliente/listado")
	public ModelAndView getClienteListadoPage() {
		
		ModelAndView modelView = new ModelAndView("Cliente");				
			
		modelView.addObject("clientes", clienteService.getCliente());
		
		return modelView;
	}
}
