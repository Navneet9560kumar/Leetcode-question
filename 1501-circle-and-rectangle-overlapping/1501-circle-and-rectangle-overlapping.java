class Solution {


    public static int clamp(int value, int min, int max) {
        return Math.max(Math.min(value, max), min);
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = clamp(xCenter, x1, x2);
        int closestY = clamp(yCenter, y1, y2);
        double distance = Math.sqrt(Math.pow(closestX - xCenter, 2) + Math.pow(closestY - yCenter, 2));
        return distance <= radius;
    }
}