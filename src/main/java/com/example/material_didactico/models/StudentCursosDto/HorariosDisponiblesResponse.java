package com.example.material_didactico.models.StudentCursosDto;

import java.util.Date;

import lombok.Data;

@Data
public class HorariosDisponiblesResponse {
	private Integer idCurso;
    private String cursoDesc;
    private Integer idAmbiente;
    private String ambienteDesc;
    private Integer cantidadVacantes;
    private Integer cantidadVacantesDisponibles;
    private Integer cantidadVacantesReservadas;
    private Integer cantidadVacantesConfirmadas;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer idModalidad;
    private String modalidadDesc;
    private Integer idSede;
    private String sedeDesc;
    private Integer idFrecuencia;
    private String frecuenciaDesc;
    private String docenteDesc;
    private String horarioDesc;
    
    private String libroDesc;
    private Integer idlibro;
    
    
    public HorariosDisponiblesResponse(HorariosDto horario) {
    	super();
    	this.idCurso = horario.getIdCurso(); // Nombre tal como está en la interfaz
    	this.cursoDesc = horario.getCursoDesc();
    	this.idAmbiente = horario.getIdAmbiente();
    	this.ambienteDesc = horario.getAmbienteDesc();
    	this.cantidadVacantes = horario.getCantidadVacantes();
    	this.cantidadVacantesDisponibles = horario.getCantidadVacantesDisponibles();
    	this.cantidadVacantesReservadas = horario.getCantidadVacantesReservadas();
    	this.cantidadVacantesConfirmadas = horario.getCantidadVacantesConfirmadas();
    	this.fechaInicio = horario.getFechaInicio();
    	this.fechaFin = horario.getFechaFin();
    	this.idModalidad = horario.getIdModalidad();
    	this.modalidadDesc = horario.getModalidadDesc();
    	this.idSede = horario.getIdSede();
    	this.sedeDesc = horario.getSedeDesc();
    	this.idFrecuencia = horario.getIdFrecuencia();
    	this.frecuenciaDesc = horario.getFrecuenciaDesc();
    	this.docenteDesc = horario.getDocenteDesc();
    	this.horarioDesc = horario.getHorarioDesc();
    	this.libroDesc = horario.getLibroDesc();
    	this.idlibro = horario.getIdLibro();
    }
	
    
    
}
