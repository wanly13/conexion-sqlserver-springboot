package com.example.material_didactico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.material_didactico.entities.AsistenciaAlumno.SA_AsistenciaEstudiante;
import com.example.material_didactico.models.AsistenciaAlumnoDto.ListadoAlumnos;
import com.example.material_didactico.models.StudentCursosDto.CabeceraDto;

@Repository
public interface AsistenciaAlumnoRepository extends JpaRepository<SA_AsistenciaEstudiante, Long>{
	@Query(value = "WITH CTE_Estudiantes AS (\r\n"
			+ "    SELECT \r\n"
			+ "        ESTUDIANTE.IdEstudiante,\r\n"
			+ "        ESTUDIANTE.NombreCompleto AS nombrecompleto,\r\n"
			+ "        ESTUDIANTE.Apellido1 AS apellidopaterno,\r\n"
			+ "        ESTUDIANTE.Apellido2 AS apellidomaterno,\r\n"
			+ "        ESTUDIANTE.NumeroDocumento AS documento\r\n"
			+ "    FROM \r\n"
			+ "        SA_EstudianteMast ESTUDIANTE\r\n"
			+ "),\r\n"
			+ "CTE_Asistencias AS (\r\n"
			+ "    SELECT\r\n"
			+ "        ASISTENCIADETALLE.IdEstudiante,\r\n"
			+ "        ASISTENCIADETALLE.AsistenciaFlag AS flagasistencia,\r\n"
			+ "        ASISTENCIADETALLE.TardanzaFlag AS flagtardanza,\r\n"
			+ "        ASISTENCIADETALLE.FaltaFlag AS flaginasistencia,\r\n"
			+ "        ASISTENCIADETALLE.JustificacionFlag AS flagobservado,\r\n"
			+ "        ASISTENCIA.FechaAsistencia,\r\n"
			+ "        ASISTENCIA.HoraInicio,\r\n"
			+ "        ASISTENCIA.HoraFin,\r\n"
			+ "        CASE \r\n"
			+ "            WHEN CAST(GETDATE() AS DATE) = CAST(ASISTENCIA.FechaAsistencia AS DATE) \r\n"
			+ "                 AND CONVERT(TIME, GETDATE()) BETWEEN ASISTENCIA.HoraInicio AND ASISTENCIA.HoraFin \r\n"
			+ "            THEN 1 -- True\r\n"
			+ "            ELSE 0 -- False\r\n"
			+ "        END AS flagdisponible\r\n"
			+ "    FROM \r\n"
			+ "        SA_AsistenciaEstudianteDetalle ASISTENCIADETALLE\r\n"
			+ "        INNER JOIN SA_AsistenciaEstudiante ASISTENCIA \r\n"
			+ "        ON ASISTENCIA.IdAsistenciaEstudiante = ASISTENCIADETALLE.IdAsistenciaEstudiante\r\n"
			+ "    WHERE \r\n"
			+ "        ASISTENCIA.CompaniaCodigo = '000001' \r\n"
			+ "        AND ASISTENCIA.UnidadNegocio = '01'\r\n"
			+ ") \r\n"
			+ "SELECT  DISTINCT\r\n"
			+ "    ROW_NUMBER() OVER (ORDER BY CTE_Asistencias.IdEstudiante) AS position,\r\n"
			+ "    CTE_Estudiantes.nombrecompleto,\r\n"
			+ "    CTE_Estudiantes.apellidopaterno,\r\n"
			+ "    CTE_Estudiantes.apellidomaterno,\r\n"
			+ "    CTE_Estudiantes.documento,\r\n"
			+ "    CTE_Asistencias.flagasistencia,\r\n"
			+ "    CTE_Asistencias.flagtardanza,\r\n"
			+ "    CTE_Asistencias.flaginasistencia,\r\n"
			+ "    CTE_Asistencias.flagobservado,\r\n"
			+ "    CTE_Asistencias.FechaAsistencia,\r\n"
			+ "    CTE_Asistencias.HoraInicio,\r\n"
			+ "    CTE_Asistencias.HoraFin,\r\n"
			+ "    CTE_Asistencias.flagdisponible\r\n"
			+ "FROM \r\n"
			+ "    CTE_Estudiantes\r\n"
			+ "    INNER JOIN CTE_Asistencias \r\n"
			+ "    ON CTE_Estudiantes.IdEstudiante = CTE_Asistencias.IdEstudiante;", 
    nativeQuery = true)
	List<ListadoAlumnos> filterlist();
}
