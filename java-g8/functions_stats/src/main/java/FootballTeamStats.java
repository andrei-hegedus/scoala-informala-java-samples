/**
 * Created by andrei on 7/26/17.
 */
public class FootballTeamStats {

    static FootballPlayer [] team = new FootballPlayer[5];

    public static void main(String[] args) {
        team[0] = new FootballPlayer();
        team[0].name = "Ion";
        team[0].appearences = 18;
        team[0].goals = 3;
        team[1] = new FootballPlayer();
        team[1].name = "Gheorghe";
        team[1].appearences = 18;
        team[1].goals = 0;
        team[2] = new FootballPlayer();
        team[2].name = "Stefan";
        team[2].appearences = 10;
        team[2].goals = 5;
        team[3] = new FootballPlayer();
        team[3].name = "Daniel";
        team[3].appearences = 15;
        team[3].goals = 5;
        team[4] = new FootballPlayer();
        team[4].name = "Alin";
        team[4].appearences = 25;
        team[4].goals = 9;

        // most used player
        FootballPlayer maxim = new FootballPlayer();
        maxim.appearences = 0;
        for(int i=0; i<5;i++){
            if(team[i].appearences>maxim.appearences){
                maxim = team[i];
            }
        }

        System.out.println(maxim.name);

        maxim = new FootballPlayer();
        maxim.goals = 0;
        for(FootballPlayer player : team){
            if(player.goals > maxim.goals){
                maxim = player;
            }
        }
        System.out.println(maxim.name);


        maxim = new FootballPlayer();
        float bestGoalPerGame = 0; // goal / game
        for(FootballPlayer player : team){
            float playerGoalPerGame = (float)player.goals / (float)player.appearences;
            if(playerGoalPerGame > bestGoalPerGame){
                bestGoalPerGame = playerGoalPerGame;
                maxim = player;
            }
        }

        System.out.println(maxim.name + " - goal/game: "+bestGoalPerGame);

    }






}
