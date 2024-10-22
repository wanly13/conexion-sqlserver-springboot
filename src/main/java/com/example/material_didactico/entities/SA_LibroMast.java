package com.example.material_didactico.entities;

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
public class SA_LibroMast {
 	@Id
    private Integer IdLibro;

    
    private String CodigoLibro;

    
    private String DescripcionLocal;

    private String DescripcionExtranjera;

    private String DescripcionCompleta;

 
    private Integer IdLinea;

 
    private Integer IdFamilia;

    
    private String TipoManejo;

   
    private String CodigoVirtualFlag;

    private String PaginaActivacion;

    private String DispoiblePortalFlag;

    private String TipoVenta;

    private String ItemCodigo;

    private String CodigoInterno;

    private String InterfazOUPFlag;

    private String Estado;

    private Integer CreadoPor;

    private Date FechaCreacion;

    private Integer ModificadoPor;

    private Date FechaModificacion;
}
