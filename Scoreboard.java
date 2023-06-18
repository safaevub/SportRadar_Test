package radar;
import java.util.*;


public class Scoreboard {
    private List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }

    public void updateScore(int matchIndex, int homeScore, int awayScore) {
        Match match = matches.get(matchIndex);
        match.updateScore(homeScore, awayScore);
    }

    public void finishMatch(int matchIndex) {
        matches.remove(matchIndex);
    }

    public List<Match> getMatchesInProgress() {
        List<Match> inProgressMatches = new ArrayList<>(matches);
        inProgressMatches.sort(Comparator.comparingInt(Match::getTotalScore).reversed()
                .thenComparing(Comparator.comparingInt(matches::indexOf).reversed()));
        return inProgressMatches;
    }
}
