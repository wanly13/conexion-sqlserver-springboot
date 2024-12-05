package com.example.material_didactico.models.AsistenciaAlumnoDto;

import java.util.List;

import com.example.material_didactico.models.StudentCursosDto.CabeceraDto;

import lombok.Data;

@Data
public class ListAsistenciaAlumnoResponse {
	private Integer position;
    private String nombreCompleto;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String documento;
    private String flagAsistencia;
    private String flagTardanza;
    private String flagInasistencia;
    private String flagObservado;
    private Boolean flagDisponible;
    
    public ListAsistenciaAlumnoResponse(ListadoAlumnos dto) {
        this.position = dto.getPosition();
        this.nombreCompleto = dto.getNombreCompleto();
        this.apellidoPaterno = dto.getApellidoPaterno();
        this.apellidoMaterno = dto.getApellidoMaterno();
        this.documento = dto.getDocumento();
        this.flagAsistencia = dto.getFlagAsistencia();
        this.flagTardanza = dto.getFlagTardanza();
        this.flagInasistencia = dto.getFlagInasistencia();
        this.flagObservado = dto.getFlagObservado();
        this.flagDisponible = dto.getFlagDisponible() == 0 ? true : false ; // 0 bloqueado, 1 desbloqueado, osea 0 significa qu no se puede modificar, y 1 si

   
    }
    
}
