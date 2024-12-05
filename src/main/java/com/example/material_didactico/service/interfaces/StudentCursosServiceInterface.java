package com.example.material_didactico.service.interfaces;



import java.util.List;

import com.example.material_didactico.models.StudentCursosDto.CabeceraDto;
import com.example.material_didactico.models.StudentCursosDto.HistorialCursoResponse;
import com.example.material_didactico.models.StudentCursosDto.HistorialRequest;
import com.example.material_didactico.models.StudentCursosDto.HorarioRequest;
import com.example.material_didactico.models.StudentCursosDto.HorariosDisponiblesResponse;


public interface StudentCursosServiceInterface  {

	
	public List<CabeceraDto> getHistorialCurso(HistorialRequest request);
	public HistorialCursoResponse getHistorialCursoDetalle(HistorialRequest request);
	public List<HorariosDisponiblesResponse> getHorariosDisponibles(HorarioRequest request);
}
