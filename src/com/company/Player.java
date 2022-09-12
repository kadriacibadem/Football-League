package com.company;

public class Player{
    private String position;
    private int defense;
    private int attack;
    private int avarage;

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAvarage() {
        return avarage;
    }

    public void setAvarage(int avarage) {
        this.avarage = avarage;
    }

    public int getGoalKepperScore() {
        return goalKepperScore;
    }

    public void setGoalKepperScore(int goalKepperScore) {
        this.goalKepperScore = goalKepperScore;
    }

    private int goalKepperScore;

    PlayerAttribute playerAttribute = new PlayerAttribute();

    // oyuncunun oynadığı mevkiye göre gücünü hesapladım
    public Player(String position) {
        this.position = position;
        if (position=="Defense"){
            defense = (playerAttribute.getPhysical()*3)+(playerAttribute.getMental())+(int)(playerAttribute.getTechnical()*0.5);
            attack = (int)(playerAttribute.getPhysical()*0.5)+(int)(playerAttribute.getMental()*0.5)+(int)(playerAttribute.getTechnical()*0.5);
            avarage = (defense + attack)/2;
        }else if (position=="Midfielder"){
            defense = playerAttribute.getPhysical() + playerAttribute.getMental() + playerAttribute.getTechnical();
            attack = (playerAttribute.getPhysical()*2) + (playerAttribute.getMental()) + (playerAttribute.getTechnical()*2);
            avarage = (defense + attack) / 2;
        }else if (position == "Striker"){
            defense = (int)(playerAttribute.getPhysical()*0.5)+(int)(playerAttribute.getMental()*0.5)+(int)(playerAttribute.getTechnical()*0.5);
            attack = (playerAttribute.getPhysical()*3)+(playerAttribute.getMental())+(int)(playerAttribute.getTechnical()*2);
            avarage = (defense + attack) / 2;
        }else{
            goalKepperScore = (playerAttribute.getMental()*2) + (playerAttribute.getPhysical()*3);
            avarage = goalKepperScore;
        }
    }
}
