package com.example.material_didactico.models.StudentCursosDto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class HistorialCursoResponse {
	private String cursonombre;
    private String descripcionlocal;
    private String nombredocente;
    private Integer progreso;
    private Long idcurso;
    private String modalidad;
    private String sede;
    private String aula;
    private Integer cantidadsesiones;
    private String frecuencia;
    private Date fechainicio;
    private Date fechafin;
    
    private List<SesionesDto> sessions;
    private List<Object> evaluations;
    private List<AsistenciaDto> attendance;
    private List<LibrosDto> libros;
    
    
    public HistorialCursoResponse(CabeceraDto dto) {
        this.cursonombre = dto.getCursonombre();
        this.descripcionlocal = dto.getDescripcionlocal();
        this.nombredocente = dto.getNombredocente();
        this.progreso = dto.getProgreso();
        this.idcurso = dto.getIdcurso();
        this.modalidad = dto.getModalidad();
        this.sede = dto.getSede();
        this.aula = dto.getAula();
        this.cantidadsesiones = dto.getCantidadsesiones();
        this.frecuencia = dto.getFrecuencia();
        this.fechainicio = dto.getFechainicio();
        this.fechafin = dto.getFechafin();

        this.sessions = List.of();
        this.libros = List.of();
        this.evaluations = List.of();
        this.attendance = List.of();
    }
    
}
