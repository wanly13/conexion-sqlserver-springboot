package com.example.material_didactico.models.AsistenciaAlumnoDto;

import org.springframework.beans.factory.annotation.Value;

public interface ListadoAlumnos {
	@Value("#{target.position}") 
	Integer getPosition();
	
	@Value("#{target.nombrecompleto}") 
    String getNombreCompleto();
	
	@Value("#{target.apellidopaterno}") 
    String getApellidoPaterno();
	
	@Value("#{target.apellidomaterno}") 
    String getApellidoMaterno();
	
	@Value("#{target.documento}") 
    String getDocumento();
	
	@Value("#{target.flagasistencia}") 
    String getFlagAsistencia();
	
	@Value("#{target.flagtardanza}")
    String getFlagTardanza();
	
	@Value("#{target.flaginasistencia}")
    String getFlagInasistencia();
	
	@Value("#{target.flagobservado}")
    String getFlagObservado();
	
	@Value("#{target.flagdisponible}")
    Integer getFlagDisponible();
}
