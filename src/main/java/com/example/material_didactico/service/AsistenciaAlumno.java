package com.example.material_didactico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.material_didactico.models.AsistenciaAlumnoDto.AsistenciaRequest;
import com.example.material_didactico.models.AsistenciaAlumnoDto.ListAsistenciaAlumnoResponse;
import com.example.material_didactico.models.AsistenciaAlumnoDto.ListadoAlumnos;
import com.example.material_didactico.repository.AsistenciaAlumnoRepository;
import com.example.material_didactico.service.interfaces.AsistenciaAlumnoInterface;


@Service
public class AsistenciaAlumno implements  AsistenciaAlumnoInterface {

	@Autowired
	AsistenciaAlumnoRepository  asistenciaAlumnoRepository; 
	
	
	public List<ListAsistenciaAlumnoResponse> filterlist(AsistenciaRequest request) {
		List<ListadoAlumnos> responseralumnos = asistenciaAlumnoRepository.filterlist();
		
		List<ListAsistenciaAlumnoResponse> response = new ArrayList<>();
		
		for (int i = 0; i < responseralumnos.size(); i++) {
            
			ListAsistenciaAlumnoResponse estudio = new ListAsistenciaAlumnoResponse(responseralumnos.get(i));
            
            
            response.add(estudio);
        }
		
		
		return response;
	}
}
