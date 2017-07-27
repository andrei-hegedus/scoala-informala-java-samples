/**
 * Created by andrei on 7/26/17.
 */
public class FootbalTeamStatsRefactored {

    static FootballPlayer[] team = new FootballPlayer[5];

    public static void main(String[] args) {
        initTeamMenber(0, "Ion", 18, 3);
        initTeamMenber(1, "Gheorghe", 18, 0);
        initTeamMenber(2, "Stefan", 10, 5);
        initTeamMenber(3, "Daniel", 15, 5);
        initTeamMenber(4, "Alin", 25, 9);


        FootballPlayer mostUsedFootballPlayer = getMostUsedFootballPlayer();
        System.out.println(mostUsedFootballPlayer.name);

        FootballPlayer bestGoalScorer = getBestGoalScorer();
        System.out.println(bestGoalScorer.name);

        FootballPlayer mostEfficientPlayer = getMostEfficientPlayer();
        System.out.println(mostEfficientPlayer.name + " - goal/game: " + computeGoalsPerGameRatio(mostEfficientPlayer));

    }

    private static FootballPlayer getMostEfficientPlayer() {
        FootballPlayer mostEfficientPlayer = new FootballPlayer();
        float bestGoalPerGame = 0; // goal / game
        for (FootballPlayer player : team) {
            float playerGoalPerGame = computeGoalsPerGameRatio(player);
            if (playerGoalPerGame > bestGoalPerGame) {
                bestGoalPerGame = playerGoalPerGame;
                mostEfficientPlayer = player;
            }
        }
        return mostEfficientPlayer;
    }

    private static float computeGoalsPerGameRatio(FootballPlayer player) {
        return (float) player.goals / (float) player.appearences;
    }

    private static FootballPlayer getBestGoalScorer() {
        FootballPlayer bestGoalScorer = new FootballPlayer();
        bestGoalScorer.goals = 0;
        for (FootballPlayer player : team) {
            if (player.goals > bestGoalScorer.goals) {
                bestGoalScorer = player;
            }
        }
        return bestGoalScorer;
    }

    private static FootballPlayer getMostUsedFootballPlayer() {
        FootballPlayer maxim = new FootballPlayer();
        maxim.appearences = 0;
        for (int i = 0; i < 5; i++) {
            if (team[i].appearences > maxim.appearences) {
                maxim = team[i];
            }
        }
        return maxim;
    }

    public static void initTeamMenber(int position, String name, int appearences, int goals) {
        team[position] = new FootballPlayer();
        team[position].name = name;
        team[position].appearences = appearences;
        team[position].goals = goals;
    }


}
