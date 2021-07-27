package com.blaller.blaseblallerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blaller.blaseblallerApi.data.Idols;
import com.blaller.blaseblallerservice.service.IdolService;

@RestController
public class IdolController {

	@Autowired
	IdolService service;

	@RequestMapping(value = "/idols/all")
	public ResponseEntity<List<String>> getAllIdols() {
		Idols idols = service.getAllIdols();
		if (idols == null) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(idols.getIdols(), HttpStatus.OK);
		}
	}

}
