package com.company;


public class Match {

    public void match(Teams team1,Teams team2){
        int homeTeamGoal = 0;
        int AwayTeamGoal = 0;

        // gücü yüksek olan takımın kazanma şansı daha yüksek fakat her zaman kazanmayacak
        // örnek olarak 1. takımın gücü 30 ikinci takımın 70 dersek 1. takımın kazanma şansı %30, ikincisini %70
        // bu şansı karşılaştırmak için iki gücü de topladım
        // daha sonra 0'dan 100e bir random sayı ürettim
        // üretilen bu sayının 70'ten az olma şansı %70 örneğin sayı 45 ise 45>30 olduğundan 2. takım kazanacak
        // sayı 20 olursa 20<30 olduğundan 1. takım kazanacak sayı eşit gelirse de takımlar berabere olacak
        int totalWeight = team1.getTeamAvaragePower() + team2.getTeamAvaragePower();
        int random = (int) Math.floor(Math.random()*(totalWeight));

        if (random < team1.getTeamAvaragePower()) {
            homeTeamGoal = random<10 ? (random>=5 ? random-4 : random) : ((random/10)>5? (random/10)-3: random/10); // absürt gol skorları çıkmasın diye sınırlama koydum
            AwayTeamGoal = (int) Math.floor(Math.random()*(homeTeamGoal)); // yenilen takımın gol sayısı max yenen takım olacağı için yenen takımın gol sayısına kadar random sayı oluşturdum
            System.out.println(team1.getTeamName()+"  "+homeTeamGoal+" - "+AwayTeamGoal+"  "+team2.getTeamName());
            team1.setTeamScore(3); // kazanan takıma 3 puan eklendi
        } else if(random>team1.getTeamAvaragePower()){
            AwayTeamGoal = random<10 ? (random>=5 ? random-4 : random) : ((random/10)>5? (random/10)-3: random/10);
            homeTeamGoal = (int) Math.floor(Math.random()*(AwayTeamGoal));
            System.out.println(team1.getTeamName()+"  "+homeTeamGoal+" - "+AwayTeamGoal+"  "+team2.getTeamName());
            team2.setTeamScore(3);
        }else {
            homeTeamGoal = (int)random<10 ? (random>=5 ? random-4 : random) : ((random/10)>5? (random/10)-3: random/10);
            AwayTeamGoal = (int)random<10 ? (random>=5 ? random-4 : random) : ((random/10)>5? (random/10)-3: random/10);
            System.out.println(team1.getTeamName()+"  "+homeTeamGoal+" - "+AwayTeamGoal+"  "+team2.getTeamName());
            team1.setTeamScore(1);
            team2.setTeamScore(1);
        }
    }

}
