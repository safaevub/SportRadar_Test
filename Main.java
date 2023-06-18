package radar;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();

        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore(0, 0, 5);

        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore(1, 10, 2);

        scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore(2, 2, 2);

        scoreboard.startMatch("Uruguay", "Italy");
        scoreboard.updateScore(3, 6, 6);

        scoreboard.startMatch("Argentina", "Australia");
        scoreboard.updateScore(4, 3, 1);

        List<Match> inProgressMatches = scoreboard.getMatchesInProgress();

        System.out.println("Summary of Matches in Progress:");
        for (Match match : inProgressMatches) {
            System.out.println(match.getSummary());
        }

    }
}
