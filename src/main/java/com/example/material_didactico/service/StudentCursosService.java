package com.example.material_didactico.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.material_didactico.models.StudentCursosDto.AsistenciaDto;
import com.example.material_didactico.models.StudentCursosDto.CabeceraDto;
import com.example.material_didactico.models.StudentCursosDto.HistorialCursoResponse;
import com.example.material_didactico.models.StudentCursosDto.HistorialRequest;
import com.example.material_didactico.models.StudentCursosDto.HorarioRequest;
import com.example.material_didactico.models.StudentCursosDto.LibrosDto;
import com.example.material_didactico.models.StudentCursosDto.HorariosDisponiblesResponse;
import com.example.material_didactico.models.StudentCursosDto.HorariosDto;
import com.example.material_didactico.models.StudentCursosDto.SesionesDto;
import com.example.material_didactico.repository.StudentCursosRepository;
import com.example.material_didactico.service.interfaces.StudentCursosServiceInterface;


@Service
public class StudentCursosService implements StudentCursosServiceInterface  {

	@Autowired
	StudentCursosRepository studentCursosRepository;
	
	
	public List<CabeceraDto> getHistorialCurso(HistorialRequest request) {
	    try {
	       
	        List<CabeceraDto> estudios = studentCursosRepository.findHistorialCursos(request.getIdestudiante());
	        
	       
//	        List<HistorialCursoResponse> response = new ArrayList<>();
//	        
//	       
//	        for (int i = 0; i < estudios.size(); i++) {
//	            
//	            HistorialCursoResponse estudio = new HistorialCursoResponse(estudios.get(i));
//	            
//	            
//	            response.add(estudio);
//	        }
	        
	        return estudios;
	    } catch (Exception e) {
	        throw new RuntimeException("Error al obtener los cursos: " + e.getMessage());
	    }
	}

	public HistorialCursoResponse getHistorialCursoDetalle(HistorialRequest request) {
	    try {
	        CabeceraDto estudios = studentCursosRepository.findHistorialCursosDetalle(request.getIdestudiante(), request.getIdcurso());
	        
	        if (estudios == null) {
	            throw new NoSuchElementException("No se encontraron estudios para el estudiante con ID " + request.getIdestudiante() + " y curso con ID " + request.getIdcurso());
	        }
	        
	        HistorialCursoResponse cursoDetalle = new HistorialCursoResponse(estudios);
	        
	        List<SesionesDto> sesiones = studentCursosRepository.getSesionesCurso(request.getIdestudiante(), request.getIdcurso());
	        
	        if(sesiones != null) {
	        	cursoDetalle.setSessions(sesiones);
	        }
	        
	        List<AsistenciaDto> asistencias = studentCursosRepository.getAsistenciaCurso(request.getIdestudiante(), request.getIdcurso());
	        
	        
	        if(asistencias != null) {
	        	cursoDetalle.setAttendance(asistencias);
	        }
	        
	        
	        List<LibrosDto> libros = studentCursosRepository.getLibrosAsociados( request.getIdcurso());
	        
	        
	        if(libros != null) {
	        	cursoDetalle.setLibros(libros);
	        }
	        
	        return cursoDetalle;
	        
	    } catch (NoSuchElementException e) {
	        throw new RuntimeException("No se encontró el curso: " + e.getMessage());
	    } catch (Exception e) {
	        throw new RuntimeException("Error al obtener los cursos: " + e.getMessage());
	    }
	}

	
	public List<HorariosDisponiblesResponse> getHorariosDisponibles(HorarioRequest request) {
		try {
			 List<HorariosDisponiblesResponse> horariosdisponibles = new ArrayList<>();
		        
		        // Obtener los datos desde el repositorio
	        List<HorariosDto> horarios = studentCursosRepository.getHorariosDisponibles(
	            request.getIdsede(),
	            request.getIdmodalidad(),
	            request.getIdcurso(),
	            request.getIdfrecuencia(),
	            request.getIdhorario()
	        );
	        if(horarios != null)  {
	        	for (HorariosDto dto : horarios) {
		            HorariosDisponiblesResponse temp = new HorariosDisponiblesResponse(dto);
		       
		            
		            horariosdisponibles.add(temp);
		        }
		        
	        }
	        
	        return horariosdisponibles;
	        
	    } catch (NoSuchElementException e) {
	        throw new RuntimeException("No se encontraron horarios disponibles ");
	    } catch (Exception e) {
	        throw new RuntimeException("Error al obtener los horarios ");
	    }
		
	}
}
