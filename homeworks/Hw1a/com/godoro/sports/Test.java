package com.godoro.sports;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Team teamGodoro = new Team(901, "Godoro Spor");
        Player player1 = new Player(301, "Neşet Ertaş", 45.2);
        Player player2 = new Player(302, "Mahsuni Şerif", 36.5);
        Player player3 = new Player(303, "Erkan Ocaklı", 71.3);

        teamGodoro.setPlayerList(new ArrayList<>());

        player1.setTeam(teamGodoro);
        player2.setTeam(teamGodoro);
        player3.setTeam(teamGodoro);

        teamGodoro.getPlayerList().add(player1);
        teamGodoro.getPlayerList().add(player2);
        teamGodoro.getPlayerList().add(player3);

        System.out.println(teamGodoro.getTeamId() + " " + teamGodoro.getTeamName());

        for (Player player : teamGodoro.getPlayerList()) {
            System.out.println("\t" + player.getPlayerId() + " " + player.getPlayerName() + " "
                    + player.getAverageScore());
        }
    }
}
