import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int[] resultAlicesRankings = new int[alice.length];

        int[] positionsOfScores = new int[scores.length];
        positionsOfScores[0] = 1;

        int currentPosition = 1;
        int currentScoreIndex = 1;
        while (currentScoreIndex <= scores.length - 1) {

            // If the scores are the same, the next score will be the same position as the current one
            if (scores[currentScoreIndex] < scores[currentScoreIndex - 1]) {
                currentPosition++;
            }
            positionsOfScores[currentScoreIndex] = currentPosition;
            currentScoreIndex++;
            // otherwise the next score is lower, since scores is in descending order, so increment position
        }
        currentScoreIndex--;

        // Since Alice's scores are ascending and scores in leaderboard are descending,
        //      We'll go through Alice's rankings starting from the end of the scores array
        for (int i = 0; i < alice.length; i++) {
            int aliceCurrentScore = alice[i];

            // This is a pre-emptive termination argument for the while loop
            if (aliceCurrentScore >= scores[0]) {
                resultAlicesRankings[i] = 1;
            } else {
                //      since alice's scores are ascending, once she reaches first place there's no need to go through scores anymore
                while (aliceCurrentScore > scores[currentScoreIndex]) {
                    currentScoreIndex--;
                }
                if (aliceCurrentScore == scores[currentScoreIndex]) {
                    resultAlicesRankings[i] = positionsOfScores[currentScoreIndex];
                } else {
                    resultAlicesRankings[i] = positionsOfScores[currentScoreIndex] + 1;
                }
            }
        }
        return resultAlicesRankings;
    }


    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(new InputStreamReader(System.in));

        String numberOfLeaderBoardScores = reader.nextLine();
        String[] leaderBoardScoresAsStringArray = reader.nextLine().split(" ");
        int[] leaderBoardScores = new int[leaderBoardScoresAsStringArray.length];
        for (int i = 0; i < leaderBoardScores.length; i++) {
            leaderBoardScores[i] = Integer.parseInt(leaderBoardScoresAsStringArray[i]);
        }

        String numberOfAliceScores = reader.nextLine();
        String[] aliceScoresAsStringArray = reader.nextLine().split(" ");
        int[] aliceScores = new int[aliceScoresAsStringArray.length];
        for (int i = 0; i < aliceScores.length; i++) {
            aliceScores[i] = Integer.parseInt(aliceScoresAsStringArray[i]);
        }


        int[] resultOfAliceRanking = climbingLeaderboard(leaderBoardScores, aliceScores);

        System.out.println(resultOfAliceRanking);
    }
}
