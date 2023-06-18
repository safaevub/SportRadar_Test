package test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ScoreboardTest {
    private Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    void testStartMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        List<Match> matchesInProgress = scoreboard.getMatchesInProgress();
        assertEquals(1, matchesInProgress.size());
        assertEquals("Mexico 0 - Canada 0", matchesInProgress.get(0).getSummary());
    }

    @Test
    void testUpdateScore() {
        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore(0, 10, 2);
        List<Match> matchesInProgress = scoreboard.getMatchesInProgress();
        assertEquals(1, matchesInProgress.size());
        assertEquals("Spain 10 - Brazil 2", matchesInProgress.get(0).getSummary());
    }

    @Test
    void testFinishMatch() {
        scoreboard.startMatch("Germany", "France");
        scoreboard.finishMatch(0);
        List<Match> matchesInProgress = scoreboard.getMatchesInProgress();
        assertEquals(0, matchesInProgress.size());
    }

    @Test
    void testGetMatchesInProgress() {
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

        List<Match> matchesInProgress = scoreboard.getMatchesInProgress();

        assertEquals(5, matchesInProgress.size());
        assertEquals("Uruguay 6 - Italy 6", matchesInProgress.get(0).getSummary());
        assertEquals("Spain 10 - Brazil 2", matchesInProgress.get(1).getSummary());
        assertEquals("Mexico 0 - Canada 5", matchesInProgress.get(2).getSummary());
        assertEquals("Argentina 3 - Australia 1", matchesInProgress.get(3).getSummary());
        assertEquals("Germany 2 - France 2", matchesInProgress.get(4).getSummary());
    }
}



