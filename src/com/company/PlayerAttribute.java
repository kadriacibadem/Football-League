package com.company;

public class PlayerAttribute{

    // oyuncunun fiziksel mental ve teknik bilgisini 1'den 20'ye kadar random atadım
    private int physical = (int) Math.floor(Math.random()*(20)+1);
    private int mental = (int) Math.floor(Math.random()*(20)+1);
    private int technical = (int) Math.floor(Math.random()*(20)+1);


    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public int getTechnical() {
        return technical;
    }

    public void setTechnical(int technical) {
        this.technical = technical;
    }
}
