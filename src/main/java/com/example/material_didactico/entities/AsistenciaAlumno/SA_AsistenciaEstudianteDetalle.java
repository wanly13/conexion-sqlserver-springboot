package com.example.material_didactico.entities.AsistenciaAlumno;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SA_AsistenciaEstudianteDetalle {
	@Id
    private Integer IdAsistenciaEstudianteDetalle;

    private Integer IdAsistenciaEstudiante;

    private Integer IdEstudiante;

    private String AsistenciaFlag;

    private String TardanzaFlag;

    private String FaltaFlag;

    private String JustificacionFlag;

    private String JustificacionMotivo;

    private Integer JustificadoPor;

    private Date FechaJustificacion;

    private String Observacion;

    private String ExamenClasificacionFlag;

    private String RepitenciaFlag;

    private Integer CreadoPor;

    private Date FechaCreacion;

    private Integer ModificadoPor;

    private Date FechaModificacion;
}
