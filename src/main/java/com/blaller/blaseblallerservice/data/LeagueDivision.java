package com.blaller.blaseblallerservice.data;

import com.blaller.blaseblallerApi.data.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueDivision {
    String id;
    List<Team> teams;
    String name;
}
