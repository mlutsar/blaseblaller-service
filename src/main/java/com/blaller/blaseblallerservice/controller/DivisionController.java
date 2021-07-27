package com.blaller.blaseblallerservice.controller;

import com.blaller.blaseblallerApi.data.Division;
import com.blaller.blaseblallerApi.data.Team;
import com.blaller.blaseblallerservice.data.LeagueDivision;
import com.blaller.blaseblallerservice.service.DivisionService;
import com.blaller.blaseblallerservice.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class DivisionController {
    @Autowired
    TeamService teamService = new TeamService();

    @Autowired
    DivisionService divisionService = new DivisionService();

    @RequestMapping(value = "/divisions/all")
    @CrossOrigin(origins = "http://localhost:3500")
    public ResponseEntity<List<LeagueDivision>> getAllActiveDivisions() {
        List<Team> teams = getLeagueTeams();
        List<Division> divisions = divisionService.getAllDivisions();
        List<LeagueDivision> leagueDivisions = createLeagueDivisions(divisions, teams);

        //List<Division> activeDivisions = switchIdToNames(divisions, teams);
        if (leagueDivisions == null || leagueDivisions.isEmpty()) {
            System.out.println("STATUS ZERO");
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            System.out.println("STATUS ONE");
            return new ResponseEntity<>(leagueDivisions, HttpStatus.OK);
        }
    }

    private List<LeagueDivision> createLeagueDivisions(List<Division> divisions, List<Team> teams) {
        List<LeagueDivision> leagueDivisions = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            LeagueDivision leagueDivision = new LeagueDivision();

            Division division = divisions.get(i);
            leagueDivision.setId(division.getId());
            leagueDivision.setName(division.getName());

            //HERE STARTS THE SHITSHOW
            //This is teams of current division
            List<String> leagueTeamIds = division.getTeams();
            //This is new teams of current division, where STRING ----> TEAM
            List<Team> newLeagueTeams = new ArrayList<>();
            for (String teamId : leagueTeamIds) {
                for (Team team : teams) {
                    if (teamId.equals(team.getId())) {
                        newLeagueTeams.add(team);
                    }
                }
            }
            leagueDivision.setTeams(newLeagueTeams);
            leagueDivisions.add(leagueDivision);
        }
        return leagueDivisions;
    }

    private List<Division> switchIdToNames(List<Division> divisions, List<Team> teams) {
        //We only have four active divisions
        for (int i = 0; i < 4; i++) {
            //First, pick a division
            Division division = divisions.get(i);
            //Get all teams from that division
            List<String> divisionTeams = division.getTeams();
            //Get all teams currently playing

            List<String> newDivisionTeams = new ArrayList<>();
            for (String teamName : divisionTeams) {
                for (Team team : teams) {
                    if (teamName.equals(team.getId())) {
                        newDivisionTeams.add(teamName);
                    }
                }
                division.setTeams(newDivisionTeams);
            }
        }
        return divisions;
    }

    //Gets team names and IDs
    public List<Team> getLeagueTeams() {
        return teamService.getAllLeagueTeams();
    }

}
