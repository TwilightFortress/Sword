package sword.矩阵;

/**
 * @author yuyang
 * @create 2019-08-07 10:45
 * */
public class e二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        //矩阵的行数
        int row = array.length - 1;
        int col = 0;
        //从矩阵的左下角开始判断
        while(row >= 0 && col <= array[0].length - 1){
            if(target == array[row][col])
                return true;
                //target大于当前数字，
            else if(target > array[row][col]){
                //右移
                col++;
            }else
                //左移
                row--;
        }
        return false;
    }
}