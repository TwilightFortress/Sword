package 常用技巧;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuyang
 * @create 2019-08-18 13:55
 */
public class 排序API之对坐标进行排序2 {
    private static List<Point1> list = new ArrayList<>();

    public static void main(String[] args) {

        //随机生成10个点
        for (int i = 0; i < 10; i++) {
            //点的坐标取值在[1,20]之间
            int x = (int) (Math.random() * 20) + 1;
            int y = (int) (Math.random() * 20) + 1;

            list.add(new Point1(x, y));
        }
        System.out.print("排序前：");
        System.out.println(list);

        //降序排序
        Collections.sort(list, new Comparator<Point1>() {

            @Override
            //当 o1 < o2 时返回正数
            public int compare(Point1 o1, Point1 o2) {
                int distance1 = (o1.getX()) * (o1.getX()) + (o1.getY()) * (o1.getY());
                int distance2 = (o2.getX()) * (o2.getX()) + (o2.getY()) * (o2.getY());

                return (distance1 < distance2) ? 1 : ((distance1 == distance2) ? 0 : -1);
            }

        });

        System.out.print("排序后：");
        System.out.println(list);
    }
}

//点类
class Point1 {

    private int x;
    private int y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}



