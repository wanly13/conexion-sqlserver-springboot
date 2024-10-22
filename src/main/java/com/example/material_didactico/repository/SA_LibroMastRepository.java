package com.example.material_didactico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.material_didactico.entities.SA_LibroMast;
import com.example.material_didactico.models.LibrosDisponibles;

public interface SA_LibroMastRepository extends JpaRepository<SA_LibroMast, Long>{
	
	@Query(value = "SELECT " +
		       "a.IdLibro AS idlibro, " +
		       "a.DescripcionLocal AS descripcionlocal, " +
		       "a.DescripcionExtranjera AS descripcionextranjera, " +
		       "a.DescripcionCompleta AS descripcioncompleta, " +
		       "a.Estado AS estado, " +
		       "a.TipoManejo AS tipomanejo, " +
		       "a.CodigoVirtualFlag AS codigovirtualflag, " +
		       "a.TipoVenta AS tipoventa, " +
		       "'80.00' AS precio " +
		       "FROM SA_LibroMast a " +  
		       "WHERE a.DispoiblePortalFlag = 'S' AND a.Estado = 'A'", 
		       nativeQuery = true)
	
		List<LibrosDisponibles> findAllAvailableBooks();


}
