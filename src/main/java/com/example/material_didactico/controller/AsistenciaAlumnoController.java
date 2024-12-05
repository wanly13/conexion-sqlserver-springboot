package com.example.material_didactico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.material_didactico.models.AsistenciaAlumnoDto.AsistenciaRequest;
import com.example.material_didactico.models.AsistenciaAlumnoDto.ListAsistenciaAlumnoResponse;

import com.example.material_didactico.service.interfaces.AsistenciaAlumnoInterface;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/asistencia-alumno")
public class AsistenciaAlumnoController {

	@Autowired
	AsistenciaAlumnoInterface asistenciaAlumnoInterface; 
	
	
	@PostMapping("/filter-list")
	public List<ListAsistenciaAlumnoResponse> getHistorialCurso(@RequestBody AsistenciaRequest request) {
		return asistenciaAlumnoInterface.filterlist(request);
		
	}
}
