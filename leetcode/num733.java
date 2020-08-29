package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class num733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor == newColor)
            return image;
        int[] rows = { 0, 0, -1, 1 };
        int[] cols = { 1, -1, 0, 0 };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r = cell[0] + rows[i];
                int c = cell[1] + cols[i];
                if (r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == currentColor) {
                    queue.offer(new int[] { r, c });
                    image[r][c] = newColor;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        floodFill(image, sr, sc, newColor);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + ' ');
            }
            System.out.println();
        }
    }
}