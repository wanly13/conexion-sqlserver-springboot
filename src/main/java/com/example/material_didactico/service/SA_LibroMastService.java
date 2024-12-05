package com.example.material_didactico.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import com.example.material_didactico.entities.SA_LibroMast;
import com.example.material_didactico.models.LibrosDisponibles;
import com.example.material_didactico.models.NiubizRequest;
import com.example.material_didactico.models.NiubizResponse;
import com.example.material_didactico.models.PayResponse;
import com.example.material_didactico.repository.SA_LibroMastRepository;
import com.example.material_didactico.service.interfaces.SA_LibroMastServiceInterface;

@Service
public class SA_LibroMastService  implements SA_LibroMastServiceInterface{
	
	@Autowired
	SA_LibroMastRepository  sA_LibroMastRepository; 
	
	public List<SA_LibroMast> getSA_LibroMast() {
		return sA_LibroMastRepository.findAll();
	}
	
	
	public List<LibrosDisponibles> findAllAvailableBooks() {
        try {
        	
            return sA_LibroMastRepository.findAllAvailableBooks();
        } catch (Exception e) {
            
            throw new RuntimeException("Error al obtener los libros disponibles: " + e.getMessage());
        }
    }
	
	public PayResponse getToken(NiubizRequest request) {
	    try {
	       
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

	       
	        String uri = "https://apisandbox.vnforappstest.com/api.security/v1/security";

	        String username = "integraciones@niubiz.com.pe";
	        String password = "_7z3@8fF";

	       
	        String auth = username + ":" + password;
	        String encodedAuth = Base64Utils.encodeToString(auth.getBytes());
	        String authHeader = "Basic " + encodedAuth;

	       
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", authHeader);
	        headers.set("Accept", "application/json");

	        HttpEntity<String> entity = new HttpEntity<>(headers);

	        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	        String tokenSecurity = response.getBody();
	        System.out.println("TOKEN: " + tokenSecurity);

	        
	        String merchantId = "456879852";
	        String uri2 = "https://apisandbox.vnforappstest.com/api.ecommerce/v2/ecommerce/token/session/" + merchantId;
	        
	       
	        RestTemplate restTemplate2 = new RestTemplate();
	        restTemplate2.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

	        HttpHeaders headers2 = new HttpHeaders();
	        headers2.set("Authorization", tokenSecurity); 
	        headers2.setContentType(MediaType.APPLICATION_JSON);
	        headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	        HttpEntity<NiubizRequest> entity2 = new HttpEntity<>(request, headers2);

	        ResponseEntity<NiubizResponse> response2 = restTemplate2.postForEntity(uri2, entity2, NiubizResponse.class);
	        NiubizResponse niubizResponse = response2.getBody();
	        
	        String sessionKey = niubizResponse.getSessionKey(); 

	        
	        PayResponse payResponse = new PayResponse();
	        payResponse.setSessionkey(sessionKey);

	        return payResponse;

	    } catch (Exception e) {
	        throw new RuntimeException("Error TOKEN-SECURITY: " + e.getMessage());
	    }
	}
//	public String getSecurityToken() {
//        String url = "https://apisandbox.vnforappstest.com/api.security/v1/security";
//        
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("accept", "text/plain");
//        headers.set("authorization", "Basic aW50ZWdyYWNpb25lc0BuaXViaXouY29tLnBlOl83ejNAOGZG");
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//
//        return response.getBody();
//    }

}
