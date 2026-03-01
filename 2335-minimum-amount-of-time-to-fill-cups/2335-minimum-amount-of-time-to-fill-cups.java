class Solution {
    public int fillCups(int[] arr) {

        PriorityQueue<Integer> max =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int ele : arr) {
            if (ele > 0)
                max.add(ele);
        }

        int seconds = 0;

        while (!max.isEmpty()) {

            int first = max.poll();

            if (!max.isEmpty()) {
                int second = max.poll();

                if (first - 1 > 0)
                    max.add(first - 1);

                if (second - 1 > 0)
                    max.add(second - 1);

            } else {
                if (first - 1 > 0)
                    max.add(first - 1);
            }

            seconds++;
        }

        return seconds;
    }
}