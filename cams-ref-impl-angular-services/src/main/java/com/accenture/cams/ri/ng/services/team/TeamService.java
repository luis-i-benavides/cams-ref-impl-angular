package com.accenture.cams.ri.ng.services.team;

import java.util.List;

import com.accenture.cams.ri.ng.domain.entity.Player;
import com.accenture.cams.ri.ng.domain.entity.Team;

public interface TeamService {
    List<Team> getTeamWithPlayers();
    void updatePlayerEF(Player player);
}
