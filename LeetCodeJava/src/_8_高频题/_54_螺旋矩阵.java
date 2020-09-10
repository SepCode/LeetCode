package _8_高频题;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top > bottom || left > right) break;

            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;

        }

        return list;
    }
}
