package sword.矩阵;

/**
 *  例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 *  但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @author yuyang
 * @create 2019-08-11 10:16
 */
public class a矩阵中的路径 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //边界
        if(matrix == null || rows < 1 || cols < 1 || str == null) return false;
        //标记矩阵中位置是否走过的
        boolean[] visited = new boolean[rows * cols];
        for(boolean b : visited)
            b = false;
        int pathLength = 0;
        //从每一个点开始遍历
        for(int row = 0; row < rows; row++)
            for(int col = 0; col < cols; col++){
                //每个点都尝试所有可能的情况
                if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited))
                    return true;
            }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited){
        if(pathLength == str.length) return true;
        boolean hasPath = false;
        //当前位置满足条件
        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row*cols + col] == str[pathLength] && !visited[row*cols + col]){
            ++pathLength;
            visited[row*cols + col] = true;
            //当前位置的可达位置任何一个满足条件都可以
            hasPath = hasPathCore(matrix,rows,cols,row,col-1,str,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row-1,col,str,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row,col+1,str,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row+1,col,str,pathLength,visited);
            //回到上一个位置
            if(!hasPath){
                --pathLength;
                visited[row*cols + col] = false;
            }
        }
        return hasPath;
    }
}
