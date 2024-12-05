package com.example.material_didactico.entities.AsistenciaAlumno;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SA_AsistenciaEstudiante {
	@Id
    private Integer IdAsistenciaEstudiante;
	
	private String CompaniaCodigo;

    private String UnidadNegocio;

    private Integer IdNivelAcademico;

    private Integer IdSede;

    private Integer IdSedeLocal;

    private Integer IdPeriodoAcademico;

    private Date FechaAsistencia;

    private String HoraInicio;

    private String HoraFin;

    private Integer IdDocente;

    private Integer IdDocentePrincipal;

    private Integer IdCurso;

    private String TipoSesion;

    private Integer IdHorario;

    private Integer IdHorarioCurso;

    private Integer IdHorarioCursoSesion;

    private Integer IdHorarioCursoSesionFecha;

    private String DPIFlag;

    private String Estado;

    private Integer CreadoPor;

    private Date FechaCreacion;

    private Integer RevisadoPor;

    private Date FechaRevision;

    private Integer AprobadoPor;

    private Date FechaAprobacion;

    private String Observaciones;
}
