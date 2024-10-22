package com.example.material_didactico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.material_didactico.entities.SA_LibroMast;
import com.example.material_didactico.models.LibrosDisponibles;
import com.example.material_didactico.service.SA_LibroMastService;

@RestController
public class SA_LibroMastController {
	
	@Autowired
	SA_LibroMastService sA_LibroMastService; 
	
	
	@GetMapping("SA_LibroMast/search")
	public List<SA_LibroMast> SA_LibroMast() {
		return sA_LibroMastService.getSA_LibroMast();
	}
	
	@GetMapping("SA_LibroMast/libros-disponibles")
	public List<LibrosDisponibles> librosDisponibles() {
		return sA_LibroMastService.findAllAvailableBooks();
	}
}
