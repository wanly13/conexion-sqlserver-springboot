package com.example.material_didactico.service;

import java.util.List;

import com.example.material_didactico.entities.SA_LibroMast;
import com.example.material_didactico.models.LibrosDisponibles;

public interface SA_LibroMastService {
	public List<SA_LibroMast> getSA_LibroMast();
	public List<LibrosDisponibles> findAllAvailableBooks();
}
