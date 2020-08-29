package leetcode;

public class num657 {
    public boolean judgeCircle(String moves) {
        int countR = 0;
        int countU = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') {
                countR++;
            } else if (moves.charAt(i) == 'L') {
                countR--;
            } else if (moves.charAt(i) == 'U') {
                countU++;
            } else if (moves.charAt(i) == 'D') {
                countU--;
            }
        }
        return countR == 0 && countU == 0;
    }
}