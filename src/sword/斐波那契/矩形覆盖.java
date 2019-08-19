package sword.斐波那契;

/**
 * @author yuyang
 * @create 2019-08-11 10:03
 */
public class 矩形覆盖 {
    public int RectCover(int target) {
        if(target <= 0) return 0;
        if(target <= 1) return 1;
        else if(target == 2){
            return 2;
        }else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
