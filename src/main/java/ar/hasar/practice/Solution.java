package main.java.ar.hasar.practice;

import java.io.*;
import java.util.*;

public class Solution {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];

        Set<Integer> scoreSet = new HashSet<>();
        for (int i = 0; i < scores.length; i++) {
            scoreSet.add(scores[i]);
        }

        List<Integer> scoreList = new ArrayList<>(scoreSet);

        Collections.sort(scoreList);
        Collections.reverse(scoreList);
        
        int startIndex = 0;
        for (int i = alice.length - 1; i >= 0; i--) {
            int aliceScore = alice[i];

            result[i] = scoreList.size() + 1;
            for (int j = startIndex; j < scoreList.size(); j++) 
            {
                if (scoreList.get(j) <= aliceScore) 
                {
                    result[i] = j + 1;
                    break;
                } else {
                    startIndex++;
                }
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
