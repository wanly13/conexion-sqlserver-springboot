package com.example.material_didactico.models.StudentCursosDto;

import java.util.Date;

public interface HorariosDto {
	Integer getIdCurso();
    String getCursoDesc();
    Integer getIdAmbiente();
    String getAmbienteDesc();
    Integer getCantidadVacantes();
    Integer getCantidadVacantesDisponibles();
    Integer getCantidadVacantesReservadas();
    Integer getCantidadVacantesConfirmadas();
    Date getFechaInicio();
    Date getFechaFin();
    Integer getIdModalidad();
    String getModalidadDesc();
    Integer getIdSede();
    String getSedeDesc();
    Integer getIdFrecuencia();
    String getFrecuenciaDesc();
    
    String getHorarioDesc();
    String getDocenteDesc();
    
    Integer getIdLibro();
    String getLibroDesc();
}
