package com.example.material_didactico.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.material_didactico.entities.SA_LibroMast;
import com.example.material_didactico.models.StudentCursosDto.AsistenciaDto;
import com.example.material_didactico.models.StudentCursosDto.CabeceraDto;
import com.example.material_didactico.models.StudentCursosDto.HorariosDto;
import com.example.material_didactico.models.StudentCursosDto.LibrosDto;
import com.example.material_didactico.models.StudentCursosDto.SesionesDto;



@Repository
public interface StudentCursosRepository extends JpaRepository<SA_LibroMast, Long>{
	
	
	@Query(value = "SELECT DISTINCT "
	        + "cm.DescripcionLocal AS cursonombre, "
	        + "cm.DescripcionLocal AS descripcionlocal, "
	        + "dm.Nombres AS nombredocente, "
	        + "80 AS progreso, "
	        + "cm.IdCurso AS idcurso, "
	        + "mem.DescripcionLocal AS modalidad, "
	        + "sde.DescripcionLocal AS sede, "
	        + "amb.DescripcionLocal AS aula, "
	        + "md.CantidadSesiones AS cantidadsesiones, "
	        + "fre.DescripcionLocal AS frecuencia, "
	        + "hc.FechaInicioHorario AS fechainicio, "
	        + "hc.FechaFinHorario AS fechafin "
	        + "FROM "
	        + "SA_CursoMast cm "
	        + "INNER JOIN SA_MatriculaDetalle md ON cm.IdCurso = md.IdCurso "
	        + "INNER JOIN SA_Matricula m ON md.IdMatricula = m.IdMatricula "
	        + "INNER JOIN SA_HorarioCurso hc ON md.IdHorarioCurso = hc.IdHorarioCurso "
	        + "INNER JOIN SA_DocenteMast dm ON hc.IdDocente = dm.IdDocente "
	        + "INNER JOIN SA_Horario h ON h.IdHorario = hc.IdHorario "
	        + "INNER JOIN SA_ModalidadEstudioMast mem ON mem.IdModalidadEstudio = h.IdModalidadEstudio "
	        + "INNER JOIN SA_SedeMast sde ON sde.IdSede = m.IdSede "
	        + "INNER JOIN SA_FrecuenciaMast fre ON fre.IdFrecuencia = hc.IdFrecuencia "
	        + "INNER JOIN SA_AmbienteMast amb ON amb.IdAmbiente = hc.IdAmbiente "
	        + "WHERE "
	        + "m.IdEstudiante = :idestudiante ",
	       nativeQuery = true)
	List<CabeceraDto> findHistorialCursos(@Param("idestudiante") Integer idestudiante);

	
	
	@Query(value = "SELECT DISTINCT "
	        + "cm.DescripcionLocal AS cursonombre, "
	        + "cm.DescripcionLocal AS descripcionlocal, "
	        + "dm.NombreCompleto AS nombredocente, "
	        + "80 AS progreso, "
	        + "cm.IdCurso AS idcurso, "
	        + "mem.DescripcionLocal AS modalidad, "
	        + "sde.DescripcionLocal AS sede, "
	        + "amb.DescripcionLocal AS aula, "
	        + "md.CantidadSesiones AS cantidadsesiones, "
	        + "fre.DescripcionLocal AS frecuencia, "
	        + "hc.FechaInicioHorario AS fechainicio, "
	        + "hc.FechaFinHorario AS fechafin "
	        + "FROM "
	        + "SA_CursoMast cm "
	        + "INNER JOIN SA_MatriculaDetalle md ON cm.IdCurso = md.IdCurso "
	        + "INNER JOIN SA_Matricula m ON md.IdMatricula = m.IdMatricula "
	        + "INNER JOIN SA_HorarioCurso hc ON md.IdHorarioCurso = hc.IdHorarioCurso "
	        + "INNER JOIN SA_DocenteMast dm ON hc.IdDocente = dm.IdDocente "
	        + "INNER JOIN SA_Horario h ON h.IdHorario = hc.IdHorario "
	        + "INNER JOIN SA_ModalidadEstudioMast mem ON mem.IdModalidadEstudio = h.IdModalidadEstudio "
	        + "INNER JOIN SA_SedeMast sde ON sde.IdSede = m.IdSede "
	        + "INNER JOIN SA_FrecuenciaMast fre ON fre.IdFrecuencia = hc.IdFrecuencia "
	        + "INNER JOIN SA_AmbienteMast amb ON amb.IdAmbiente = hc.IdAmbiente "
	        + "WHERE "
	        + "m.IdEstudiante = :idestudiante AND cm.IdCurso = :idcurso",
	       nativeQuery = true)
	CabeceraDto findHistorialCursosDetalle(@Param("idestudiante") Integer idestudiante, @Param("idcurso") Integer idcurso);

	@Query(value = "SELECT DISTINCT  \r\n"
			+ "    fecha.IdHorarioCursoSesionFecha AS 'nombre',\r\n"
			+ "    fecha.HoraInicio AS 'horainicio',\r\n"
			+ "    fecha.HoraFin AS 'horafin',\r\n"
			+ "    fecha.Fecha AS 'fecha'\r\n"
			+ "FROM \r\n"
			+ "    SA_CursoMast curso\r\n"
			+ "INNER JOIN SA_MatriculaDetalle matriculadetalle \r\n"
			+ "    ON curso.IdCurso = matriculadetalle.IdCurso\r\n"
			+ "INNER JOIN SA_Matricula matricula \r\n"
			+ "    ON matricula.IdMatricula = matriculadetalle.IdMatricula\r\n"
			+ "INNER JOIN SA_HorarioCursoFecha fecha \r\n"
			+ "    ON matriculadetalle.IdHorarioCurso = fecha.IdHorarioCurso\r\n"
			+ "    AND matriculadetalle.IdHorarioCursoSesion = fecha.IdHorarioCursoSesion\r\n"
			+ "WHERE \r\n"
			+ "    matricula.IdEstudiante = :idestudiante AND curso.IdCurso = :idcurso;",
	       nativeQuery = true)
	List<SesionesDto> getSesionesCurso(@Param("idestudiante") Integer idestudiante, @Param("idcurso") Integer idcurso);
	
	@Query(value = "SELECT DISTINCT \r\n"
			+ "    curso.IdCurso, \r\n"
			+ "  \r\n"
			+ "    matricula.IdEstudiante, \r\n"
			+ "     fecha.IdHorarioCursoSesionFecha AS 'nombre',\r\n"
			+ "    fecha.HoraInicio AS 'horainicio',\r\n"
			+ "    fecha.HoraFin AS 'horafin',\r\n"
			+ "    fecha.Fecha AS 'fecha',\r\n"
			+ "    \r\n"
			+ "    CASE \r\n"
			+ "        WHEN asistenciadetalle.AsistenciaFlag = 'S' THEN 'A'\r\n"
			+ "        WHEN asistenciadetalle.TardanzaFlag = 'S' THEN 'T'\r\n"
			+ "        WHEN asistenciadetalle.FaltaFlag = 'S' THEN 'F'\r\n"
			+ "        ELSE 'N/A' -- En caso de que no haya registro de asistencia\r\n"
			+ "    END AS Asistencia\r\n"
			+ "FROM \r\n"
			+ "    SA_CursoMast curso\r\n"
			+ "INNER JOIN SA_MatriculaDetalle matriculadetalle \r\n"
			+ "    ON curso.IdCurso = matriculadetalle.IdCurso\r\n"
			+ "INNER JOIN SA_Matricula matricula \r\n"
			+ "    ON matricula.IdMatricula = matriculadetalle.IdMatricula\r\n"
			+ "INNER JOIN SA_HorarioCursoFecha fecha \r\n"
			+ "    ON matriculadetalle.IdHorarioCurso = fecha.IdHorarioCurso\r\n"
			+ "    AND matriculadetalle.IdHorarioCursoSesion = fecha.IdHorarioCursoSesion\r\n"
			+ "LEFT JOIN SA_AsistenciaEstudiante asistencia \r\n"
			+ "    ON matriculadetalle.IdHorarioCurso = asistencia.IdHorarioCurso\r\n"
			+ "    AND matriculadetalle.IdHorarioCursoSesion = asistencia.IdHorarioCursoSesion\r\n"
			+ "    AND fecha.IdHorarioCursoSesionFecha = asistencia.IdHorarioCursoSesionFecha\r\n"
			+ "LEFT JOIN SA_AsistenciaEstudianteDetalle asistenciadetalle\r\n"
			+ "    ON asistencia.IdAsistenciaEstudiante = asistenciadetalle.IdAsistenciaEstudiante\r\n"
			+ "   \r\n"
			+ "WHERE \r\n"
			+ "     matricula.IdEstudiante = :idestudiante AND curso.IdCurso = :idcurso;",
	       nativeQuery = true)
	List<AsistenciaDto> getAsistenciaCurso(@Param("idestudiante") Integer idestudiante, @Param("idcurso") Integer idcurso);
	
	
	@Query(value = "SELECT \r\n"
			+ "	CodigoLibro as 'codigolibro',\r\n"
			+ "	DescripcionLocal as 'descripcionlibro',\r\n"
			+ "	CodigoVirtualFlag as 'flagvirtual', \r\n"
			+ "	PaginaActivacion as 'paginaactivacion',\r\n"
			+ "	TipoManejo as 'tipomanejo'\r\n"
			+ "	\r\n"
			+ "FROM SA_LibroMast WHERE IdLibro IN (\r\n"
			+ "	SELECT IdLibroRelacionado FROM SA_CursoLibro WHERE IdCurso = :idcurso\r\n"
			+ ") AND Estado = 'A';",
	       nativeQuery = true)
	List<LibrosDto> getLibrosAsociados( @Param("idcurso") Integer idcurso);
	
	@Query(value = """
	        WITH LibroRelacionado AS (
			    SELECT 
			        cl.IdCurso,
			        lm.IdLibro,
			        lm.DescripcionLocal,
			        ROW_NUMBER() OVER (PARTITION BY cl.IdCurso ORDER BY lm.CodigoLibro) AS rn
			    FROM SA_CursoLibro cl
			    LEFT JOIN SA_LibroMast lm ON lm.IdLibro = cl.IdLibroRelacionado AND lm.Estado = 'A'
			)
			SELECT 
			    hc.IdCurso AS idcurso,
			    c.DescripcionLocal AS cursodesc,
			    hc.IdAmbiente AS idambiente,
			    a.DescripcionLocal AS ambientedesc,
			    hc.CantidadVacantes AS cantidadvacantes,
			    hc.CantidadVacantesDisponibles AS cantidadvacantesdisponibles,
			    hc.CantidadVacantesReservadas AS cantidadvacantesreservadas,
			    hc.CantidadVacantesConfirmadas AS cantidadvacantesconfirmadas,
			    hc.FechaInicioHorario AS fechainicio,
			    hc.FechaFinHorario AS fechafin,
			    h.IdModalidadEstudio AS idmodalidad,
			    m.DescripcionLocal AS modalidaddesc,
			    h.IdSede AS idsede,
			    s.DescripcionLocal AS sededesc,
			    hc.IdFrecuencia AS idfrecuencia,
			    f.DescripcionLocal AS frecuenciadesc,
			    d.Nombres AS docentedesc,
			    hm.DescripcionLocal AS horarioDesc,
			    lr.IdLibro AS idlibro,
			    lr.DescripcionLocal AS libroDesc
			FROM SA_Horario h
			INNER JOIN SA_HorarioCurso hc ON hc.IdHorario = h.IdHorario
			INNER JOIN SA_CursoMast c ON c.IdCurso = hc.IdCurso
			INNER JOIN SA_AmbienteMast a ON a.IdAmbiente = hc.IdAmbiente
			INNER JOIN SA_SedeMast s ON s.IdSede = h.IdSede
			INNER JOIN SA_FrecuenciaMast f ON f.IdFrecuencia = hc.IdFrecuencia
			INNER JOIN SA_ModalidadEstudioMast m ON m.IdModalidadEstudio = h.IdModalidadEstudio
			INNER JOIN SA_HorarioMast hm ON hm.IdHorario = hc.IdHorario
			INNER JOIN SA_DocenteMast d ON d.IdDocente = hc.IdDocente
			LEFT JOIN LibroRelacionado lr ON lr.IdCurso = hc.IdCurso AND lr.rn = 1
	        WHERE h.IdSede = :idSede
	          AND h.IdModalidadEstudio = :idModalidad
	          AND hc.IdCurso = :idCurso
	          AND hc.IdFrecuencia = :idFrecuencia
	          AND hc.IdHorario = :idHorario
	    """, nativeQuery = true)
	    List<HorariosDto> getHorariosDisponibles(
	        @Param("idSede") Integer idSede,
	        @Param("idModalidad") Integer idModalidad,
	        @Param("idCurso") Integer idCurso,
	        @Param("idFrecuencia") Integer idFrecuencia,
	        @Param("idHorario") Integer idHorario
	    );
}
