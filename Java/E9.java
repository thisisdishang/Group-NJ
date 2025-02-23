// Count score in cricket

package Java;

import java.util.*;

public class E9 {
    public static void main(String args[]) {
        BattingTeam battingTeam = new BattingTeam(1);
        BowlingTeam bowlingTeam = new BowlingTeam(2);

        Inning one = new Inning();
        String inputover = "1.2wW6.2b34";
        one.describe(battingTeam, bowlingTeam, inputover);
    }
}

class Inning {
    private Player striker;
    private Player nonstriker;
    private int ballsofover;
    private int wickets;
    private ArrayList<Player> battingQueue;
    private int extras;
    private int[] playerRuns;

    public void describe(BattingTeam T1, BowlingTeam T2, String input) {
        battingQueue = T1.getPlayers();
        this.striker = battingQueue.get(0);
        this.nonstriker = battingQueue.get(1);
        this.playerRuns = new int[11];
        this.wickets = 0;
        this.extras = 0;
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char currentBall = input.charAt(i);
            if (Character.isDigit(currentBall)) {
                int runsToAdd = currentBall - '0';
                striker.setPruns(striker.getPruns() + runsToAdd);
                T1.setTruns(T1.getTruns() + runsToAdd);
                ballsofover++;
                output += "P" + striker.getPid() + " hits a " + runsToAdd;
                if (runsToAdd % 2 != 0) {
                    Player temp = striker;
                    striker = nonstriker;
                    nonstriker = temp;
                }
            } else if (currentBall == '.') {
                ballsofover++;
                output += "P" + striker.getPid() + " a dot ball";
            } else if (currentBall == 'w') {
                T1.setTruns(T1.getTruns() + 1);
                extras++;
                output += "wide ball";
            } else if (currentBall == 'W') {
                wickets++;
                output += "P" + striker.getPid() + " is out";
                playerRuns[striker.getPid()] = striker.getPruns();
                striker = battingQueue.get(wickets + 1);
                output += ", P" + striker.getPid() + " is in";
                ballsofover++;
            } else if (currentBall == 'b') {
                ballsofover++;
                T1.setTruns(T1.getTruns() + 1);
                Player temp = striker;
                striker = nonstriker;
                nonstriker = temp;
                extras++;
                output += "Bye P" + striker.getPid() + " on strike";
            }

            System.out.print("Score of Ball " + ballsofover + " is: " + output);
            System.out.println(", T" + T1.getTid() + " Runs: " + T1.getTruns());
            output = "";

            if (ballsofover == 6) {
                ballsofover = 0;
                Player temp = striker;
                striker = nonstriker;
                nonstriker = temp;
                System.out.println("\nNew Over (P" + striker.getPid() + " on strike)");
            }
        }

        playerRuns[striker.getPid()] = striker.getPruns();
        playerRuns[nonstriker.getPid()] = nonstriker.getPruns();

        System.out.println();
        for (int i = 1; i < playerRuns.length; i++) {
            System.out.println("P" + i + ": " + playerRuns[i]);
        }
        System.out.println("extras: " + extras);
    }
}

class Player {

    private int pid;
    private int tid;
    private int pruns;

    public Player(int pid, int tid) {
        this.pid = pid;
        this.tid = tid;
    }

    public int getPid() {
        return pid;
    }

    public int getPruns() {
        return pruns;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setPruns(int pruns) {
        this.pruns = pruns;
    }

}

class Team {

    private int tid;
    private ArrayList<Player> players = new ArrayList<>();

    public Team(int tid) {
        this.tid = tid;
        addPlayers(this.players, this.tid);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    private void addPlayers(ArrayList<Player> players, int tid) {
        for (int i = 1; i <= 11; i++) {
            Player newPlayer = new Player(i, tid);
            players.add(newPlayer);
        }
    }

}

class BattingTeam extends Team {

    private int truns;

    public BattingTeam(int tid) {
        super(tid);
        this.truns = 0;
    }

    public int getTruns() {
        return truns;
    }

    public void setTruns(int truns) {
        this.truns = truns;
    }

}

class BowlingTeam extends Team {

    public BowlingTeam(int tid) {
        super(tid);
    }

}