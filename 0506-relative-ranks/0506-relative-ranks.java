import java.util.*;

class Pair {
    int score;
    int index;

    Pair(int score, int index) {
        this.score = score;
        this.index = index;
    }
}

class Solution {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] answer = new String[n];

        // max heap based on score
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> b.score - a.score
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(score[i], i));
        }

        int rank = 1;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            if (rank == 1) {
                answer[current.index] = "Gold Medal";
            } else if (rank == 2) {
                answer[current.index] = "Silver Medal";
            } else if (rank == 3) {
                answer[current.index] = "Bronze Medal";
            } else {
                answer[current.index] = String.valueOf(rank);
            }

            rank++;
        }

        return answer;
    }
}