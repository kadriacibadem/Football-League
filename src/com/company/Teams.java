package com.company;


public class Teams {
    private String teamName;
    private int teamScore;
    private int teamDefensePower = 0;
    private int teamAttackPower = 0;
    private int teamAvaragePower = 0;

    public int getTeamDefensePower() {
        return teamDefensePower;
    }

    public void setTeamDefensePower(int teamDefensePower) {
        this.teamDefensePower = teamDefensePower;
    }

    public int getTeamAttackPower() {
        return teamAttackPower;
    }

    public void setTeamAttackPower(int teamAttackPower) {
        this.teamAttackPower = teamAttackPower;
    }

    public int getTeamAvaragePower() {
        return teamAvaragePower;
    }

    public void setTeamAvaragePower(int teamAvaragePower) {
        this.teamAvaragePower = teamAvaragePower;
    }

    public Teams(String teamName, int teamScore) {
        this.teamName = teamName;
        this.teamScore = teamScore;

        for (int i=0;i<11;i++){
            teamDefensePower += players[i].getDefense();
            teamAttackPower += players[i].getAttack();
            teamAvaragePower += players[i].getAvarage();
        }
        teamAvaragePower = (teamAvaragePower) / 11;
        teamAttackPower = (teamAttackPower) / 11;
        teamDefensePower = (teamDefensePower) / 11;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore += teamScore;
    }

    // her takım için 11 oyuncu oluşturdum
    Player[] players = {new Player("GoalKepper"),
            new Player("Defense"),
            new Player("Defense"),
            new Player("Defense"),
            new Player("Defense"),
            new Player("Midfielder"),
            new Player("Midfielder"),
            new Player("Midfielder"),
            new Player("Midfielder"),
            new Player("Striker"),
            new Player("Striker"),
    };

    public void getTeamPlayers(){
        for (int i =0;i<11;i++){
            System.out.println(players[i].getAvarage());
        }
    }

}
