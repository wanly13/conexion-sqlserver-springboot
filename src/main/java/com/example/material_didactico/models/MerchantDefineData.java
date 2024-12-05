package com.example.material_didactico.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MerchantDefineData {
	@JsonProperty("MDD4")
	String MDD4;
	@JsonProperty("MDD32")
	String MDD32;
	@JsonProperty("MDD75")
	String MDD75;
	@JsonProperty("MDD77")
	Integer MDD77;
	
}
