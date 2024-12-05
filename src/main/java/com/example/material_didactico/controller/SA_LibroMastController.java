package com.example.material_didactico.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.material_didactico.entities.SA_LibroMast;
import com.example.material_didactico.models.LibrosDisponibles;
import com.example.material_didactico.models.NiubizRequest;
import com.example.material_didactico.models.NiubizResponse;
import com.example.material_didactico.models.PayResponse;
import com.example.material_didactico.service.interfaces.SA_LibroMastServiceInterface;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/SA_LibroMast")
public class SA_LibroMastController {
	
	@Autowired
	SA_LibroMastServiceInterface sA_LibroMastService; 
	

	@GetMapping("search")
	public List<SA_LibroMast> SA_LibroMast() {
		return sA_LibroMastService.getSA_LibroMast();
	}

	@GetMapping("libros-disponibles")
	public List<LibrosDisponibles> librosDisponibles() {
		return sA_LibroMastService.findAllAvailableBooks();
	}
	

	@PostMapping("get-session-niubiz")
	public PayResponse getSesion(@RequestBody NiubizRequest request) {
		return sA_LibroMastService.getToken(request);
		
	}
}
