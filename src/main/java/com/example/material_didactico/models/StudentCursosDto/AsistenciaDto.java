package com.example.material_didactico.models.StudentCursosDto;

import java.util.Date;

public interface AsistenciaDto {
	String getNombre();
	String getAsistencia();
    Date getFecha();
    Date getHoraInicio();
    Date getHoraFin();
}
