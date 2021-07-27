package com.blaller.blaseblallerservice.service;

import com.blaller.blaseblallerApi.data.Team;
import com.blaller.blaseblallerApi.endpoint.TeamsEndpoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    public List<Team> getAllTeams() {
        return TeamsEndpoint.getTeams();
    }

    public List<Team> getAllLeagueTeams() {
        return TeamsEndpoint.getTeamNamesAndIds();
    }

}
