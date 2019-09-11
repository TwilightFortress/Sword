package others;

import java.util.Scanner;

/**
 * 2048左移
 * @author yuyang
 * @create 2019-09-11 20:04
 */
/*
4
0 0 2 4
0 2 2 2
0 4 2 2
8 8 2 2
输出
2 4 0 0
4 2 0 0
4 4 0 0
16 4 0 0
 */
public class 左移2048 {
    static String solution(String[] input) {
        int row = input.length;
        String[] arrStr = input[0].split(" ");
        int col = arrStr.length;
        int[][] arrs = new int[row][col];
        for (int i = 0; i < row; i++) {
            String l = input[i];
            String[] arrStr1 = l.split(" ");
            for (int j = 0; j < col; j++) {
                arrs[i][j] = Integer.parseInt(arrStr1[j]);
            }
        }
        int[][] res = getArrs(arrs, row, col);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(res[i][j]);
                if (j < col - 1)
                    sb.append(" ");
            }
            if (i < row - 1)
                sb.append("\n");
        }
        return sb.toString();

    }

    private static int[][] getArrs(int[][] map, int rols, int cols) {
        int[][] res = new int[rols][cols];
        for (int i = 0; i < rols; i++) {
            int[] arr = new int[cols];
            int[] line = map[i];
            int zerocount = 0;
            int index = 0;
            for (int j = 0; j < cols; j++) {
                if (line[j] == 0) {
                    zerocount++;
                    continue;
                }
                if (j + 1 < cols && line[j] == line[j + 1]) {
                    arr[index++] = line[j] + line[j + 1];
                    j++;
                } else {
                    arr[index++] = line[j];
                }
            }
            for (int j = 0; j < cols; j++) {
                res[i][j] = arr[j];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for (int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }
}




















