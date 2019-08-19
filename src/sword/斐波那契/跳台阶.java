package sword.斐波那契;

/**
 * @author yuyang
 * @create 2019-08-11 10:02
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target ==2) {
            return 2;
        } else {
            return  JumpFloor(target-1)+JumpFloor(target-2);
        }
    }
}
