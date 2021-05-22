package com.blaller.blaseblallerservice.service;

import org.springframework.stereotype.Service;

import com.blaller.blaseblallerApi.data.Idols;
import com.blaller.blaseblallerApi.endpoint.IdolsEndpoint;

@Service
public class IdolService {
	
	public Idols getAllIdols() {
		Idols idols = IdolsEndpoint.getIdols();
		return idols;
	}

}
