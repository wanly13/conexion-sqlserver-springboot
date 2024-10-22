package com.example.material_didactico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.material_didactico.entities.SA_LibroMast;
import com.example.material_didactico.models.LibrosDisponibles;
import com.example.material_didactico.repository.SA_LibroMastRepository;

@Service
public class SA_LibroMastServiceJPA  implements SA_LibroMastService{
	
	@Autowired
	SA_LibroMastRepository  sA_LibroMastRepository; 
	
	public List<SA_LibroMast> getSA_LibroMast() {
		return sA_LibroMastRepository.findAll();
	}
	
	
	public List<LibrosDisponibles> findAllAvailableBooks() {
        try {
        	
            return sA_LibroMastRepository.findAllAvailableBooks();
        } catch (Exception e) {
            
            throw new RuntimeException("Error al obtener los libros disponibles: " + e.getMessage());
        }
    }
}
