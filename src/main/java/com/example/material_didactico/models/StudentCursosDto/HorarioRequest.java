package com.example.material_didactico.models.StudentCursosDto;

import lombok.Data;

@Data
public class HorarioRequest {
	
	private Integer idestudiante; 
    private String nombres; 
    private String apellido1; 
    private String apellido2; 
    private String tipoDocumento; 
    private String numeroDocumento; 
    private Integer idcurso; 
    private Integer idlibro; 
    private Integer idmodalidad;
    private Integer idsede; 
    private Integer idfrecuencia; 
    private Integer idhorario; 
    private Integer idmateria; 
    private Integer idconvenio; 
}
