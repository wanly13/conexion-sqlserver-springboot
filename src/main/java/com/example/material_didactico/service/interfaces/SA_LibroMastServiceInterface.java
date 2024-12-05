package com.example.material_didactico.service.interfaces;

import java.util.List;

import com.example.material_didactico.entities.SA_LibroMast;
import com.example.material_didactico.models.LibrosDisponibles;
import com.example.material_didactico.models.NiubizRequest;
import com.example.material_didactico.models.PayResponse;

public interface SA_LibroMastServiceInterface {
	public List<SA_LibroMast> getSA_LibroMast();
	public List<LibrosDisponibles> findAllAvailableBooks();
	public PayResponse getToken(NiubizRequest request);
}
