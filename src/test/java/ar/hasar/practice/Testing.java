package test.java.ar.hasar.practice;

import java.io.*;
import java.util.*;

public class Testing
{

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

    public static void main(String[] args) throws IOException {
    
    	//
    	//Ejemplo de entrada
    	//100 100 50 40 40 20 10
    	//5 25 50 120
    	
        int[] scores = new int[] { 100, 100, 50, 40, 40, 20, 10 };
        int[] alice = new int[] { 5, 25, 50, 120 };
        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
        }
        
        //output
        //6
        //4
        //2
        //1

    }
    
}
