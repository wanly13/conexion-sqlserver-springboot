package com.example.material_didactico.models;

import lombok.Data;

@Data
public class PayResponse {
	String sessionkey;
	Antifraude antifraud;
	DataMap dataMap;
}
