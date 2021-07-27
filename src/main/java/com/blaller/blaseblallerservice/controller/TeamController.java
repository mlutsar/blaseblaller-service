package com.blaller.blaseblallerservice.controller;

import com.blaller.blaseblallerApi.data.Team;
import com.blaller.blaseblallerservice.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService service;

    @RequestMapping(value = "/teams/all")
    @CrossOrigin(origins = "http://localhost:3500")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = service.getAllTeams();
        if (teams == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(teams, HttpStatus.OK);
        }
    }

}
