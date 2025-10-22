package Graphs;
import java.util.*;
public class FloodFillAlgo {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        int iniColor = image[sr][sc];
        int[][] ans = image;
        if (iniColor == newColor) return ans;
        ColorPixels(image, ans, sr, sc, m, n, newColor, iniColor);
        return ans;
    }

    private void ColorPixels(int[][] img, int[][] ans, int row, int col,int m, int n, int newColor, int iniColor){
        ans[row][col] = newColor;

        // UpSide
        if (row > 0 && img[row-1][col] == iniColor){
            ColorPixels(img, ans, row - 1, col, m, n, newColor, iniColor);
        }
        // RightSide
        if (col < n - 1 && img[row][col + 1] == iniColor){
            ColorPixels(img, ans, row, col + 1, m, n, newColor, iniColor);
        }
        // DownSide
        if (row < m - 1 && img[row + 1][col] == iniColor){
            ColorPixels(img, ans, row + 1, col, m, n, newColor, iniColor);
        }
        // LeftSide
        if (col > 0 && img[row][col - 1] == iniColor){
            ColorPixels(img, ans, row, col - 1, m, n, newColor, iniColor);
        }
    }
}
