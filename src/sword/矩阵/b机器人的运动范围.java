package sword.矩阵;

/**
 * @author yuyang
 * @create 2019-08-11 10:17
 */
public class b机器人的运动范围 {
    public int movingCount(int threshold, int rows, int cols)
    {
        //边界处理
        if(threshold < 0 || rows < 1 || cols < 1) return 0;
        //定义所需变量并初始化
        int count = 0;
        boolean[] visited = new boolean[rows * cols];
        for(boolean b : visited){
            b = false;
        }
        //从(0,0)位置点开始走
        count = moving(threshold, rows, cols, 0, 0, visited);
        return count;
    }
    public int moving(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0;
        if(row >=0 && row < rows && col >=0 && col < cols && !visited[row * cols + col] && getDigitNum(row) + getDigitNum(col) <= threshold){
            visited[row * cols + col] = true;
            //走一步加1
            count = 1 + moving(threshold, rows, cols, row - 1, col, visited)
                    + moving(threshold, rows, cols, row, col - 1, visited)
                    + moving(threshold, rows, cols, row + 1, col, visited)
                    + moving(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }
    public int getDigitNum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
