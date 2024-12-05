package com.example.material_didactico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.material_didactico.models.StudentCursosDto.CabeceraDto;
import com.example.material_didactico.models.StudentCursosDto.HistorialCursoResponse;
import com.example.material_didactico.models.StudentCursosDto.HistorialRequest;
import com.example.material_didactico.models.StudentCursosDto.HorarioRequest;
import com.example.material_didactico.models.StudentCursosDto.HorariosDisponiblesResponse;
import com.example.material_didactico.service.interfaces.StudentCursosServiceInterface;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/StudentCursos")
public class StudentCursosController {
	
	@Autowired
	StudentCursosServiceInterface studentCursosService; 
	
	@PostMapping("/historial")
	public List<CabeceraDto> getHistorialCurso(@RequestBody HistorialRequest request) {
		return studentCursosService.getHistorialCurso(request);
		
	}
	@PostMapping("/historial-detalle")
	public HistorialCursoResponse getHistorialCursoDetalle(@RequestBody HistorialRequest request) {
		return studentCursosService.getHistorialCursoDetalle(request);
		
	}

	@GetMapping("/search")
	public ResponseEntity<String> search() {
		return ResponseEntity.ok("Jola muiendo cruel");
		
	}
	
	@PostMapping("/horarios-disponibles")
	public List<HorariosDisponiblesResponse> getCursosDisponiblesMatricula(@RequestBody HorarioRequest request) {
		return studentCursosService.getHorariosDisponibles(request);
		
	}
}

