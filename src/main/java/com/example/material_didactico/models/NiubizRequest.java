package com.example.material_didactico.models;

import lombok.Data;

@Data
public class NiubizRequest {
	String channel;
	Integer amount;
	Antifraude  antifraud;
	DataMap dataMap;
	
	
}
