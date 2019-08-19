package 常用技巧;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yuyang
 * @create 2019-08-18 13:50
 */
public class 排序API之对坐标进行排序 {
    private static List<Point> list = new ArrayList<>();

    public static void main(String[] args) {

        //随机生成10个点
        for(int i = 0; i < 10; i++)
        {
            //点的坐标取值在[1,20]之间
            int x = (int)(Math.random() * 20) + 1;
            int y = (int)(Math.random() * 20) + 1;

            list.add(new Point(x,y));
        }
        System.out.print("排序前：");
        System.out.println(list);

        //降序排序
        Collections.sort(list,Collections.reverseOrder());

        System.out.print("排序后：");
        System.out.println(list);
    }
}
class Point implements Comparable<Point>{

    private int x;
    private int y;

    public Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    //如果该点到原点的距离大于o点到原点的距离，则该点大于o点
    public int compareTo(Point o) {

        int distance1 = (this.x) * (this.x) + (this.y) * (this.y);
        int distance2 = (o.x) * (o.x) + (o.y) * (o.y);

        return (distance1 > distance2) ? 1 : ((distance1 == distance2) ? 0 : -1);
    }

    @Override
    public String toString() {
        return "(" + x + ","+  y + ")";
    }
}
