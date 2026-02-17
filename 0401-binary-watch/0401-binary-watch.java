class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        
        for (int hh = 0; hh <= 11; hh++) {
            for (int mm = 0; mm <= 59; mm++) {
                if (Integer.bitCount(hh) + Integer.bitCount(mm) == turnedOn) {
                    String hour = String.valueOf(hh);
                    String minute = (mm < 10 ? "0" : "") + mm;
                    res.add(hour + ":" + minute);
                }
            }
        }
        
        return res;
    }
}
