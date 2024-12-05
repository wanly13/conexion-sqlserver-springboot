package com.example.material_didactico.service.interfaces;

import java.util.List;

import com.example.material_didactico.models.AsistenciaAlumnoDto.AsistenciaRequest;
import com.example.material_didactico.models.AsistenciaAlumnoDto.ListAsistenciaAlumnoResponse;

public interface AsistenciaAlumnoInterface {
	public List<ListAsistenciaAlumnoResponse> filterlist(AsistenciaRequest request);
}
