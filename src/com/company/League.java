package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class League {
    List<Teams> teams = new LinkedList<Teams>();
    Match match = new Match();
    FixtureGenerator<Teams> fixtureGenerator = new FixtureGenerator();

    // 19 adet takım oluşturur
    public League(){
        for (int i=1;i<19;i++){
            teams.add(new Teams("Team "+i,0));
        }
    }


    public void createLeague(){
        // 19 takımı alarak fikstür çekimi yapar ve rounds'un içine atar
        List<List<Fixture<Teams>>> rounds = fixtureGenerator.getFixtures(teams, true);
        // Haftalık olarak fikstürü ekranda gösterir
        for(int i=0; i<rounds.size(); i++){
            System.out.println((i+1)+". Hafta");
            List<Fixture<Teams>> round = rounds.get(i);
            for(Fixture<Teams> fixture: round){
                System.out.println(fixture.getHomeTeam().getTeamName() + " - " + fixture.getAwayTeam().getTeamName());
            }
            System.out.println("");
        }

        // Çekilen fikstüre göre maçları oynatır ve sonuçları ekranda gösterir
        for(int i=0; i<rounds.size(); i++){
            System.out.println("\n----------------------------------- \n\n");
            System.out.println((i+1)+". Hafta");
            List<Fixture<Teams>> round = rounds.get(i);
            for(Fixture<Teams> fixture: round){
                match.match(fixture.getHomeTeam(),fixture.getAwayTeam());
            }
            System.out.println("\n");
            standings(teams); // maçlardan sonra puan durumunu ekrana yazar
            System.out.println("");
        }
    }

    // puan durumunu ekrana yazdırmak için
    public void standings(List<Teams> teams){
        List<Teams> sortingTeams = teams.stream().sorted(Comparator.comparing(Teams::getTeamScore).reversed()).collect(Collectors.toList());

        for (int i=0;i< sortingTeams.size();i++){
            System.out.println(sortingTeams.get(i).getTeamName()+"   "+sortingTeams.get(i).getTeamScore());
        }
    }

}
