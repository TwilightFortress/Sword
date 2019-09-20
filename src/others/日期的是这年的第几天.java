package others;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-16 14:48
 */
public class 日期的是这年的第几天 {

    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你要判断的日期(xxxx年xx月xx日):");
        String dateIn = scan.nextLine();
        if (dateIn.length() == 11) {
            int year = Integer.parseInt(dateIn.substring(0, 4));    //获取输入的年份
            int month = Integer.parseInt(dateIn.substring(5, 7));    //获取输入的月份
            int day = Integer.parseInt(dateIn.substring(8, 10));    //获取输入的日数
            System.out.println("day=" + dateIn.substring(8, 10));
            LocalDate date = LocalDate.of(year, month, day);        //将其转换为Java8中的LocalDate类型
            System.out.println("转换结果：" + year + "-" + month + "-" + day);
            int[] arr = new int[]{31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};    //定义数组，存放截至每个月为止当年的天数
            int count = 0;        //声明变量，存放计算结果(天数)
            if (month == 1) {        // 如果是一月，天数就是当前的日数
                count = day;
            }
            if (date.isLeapYear()) {    // 判断输入的年份是否是瑞年(Java8中新特性)
                System.out.println("是瑞年");
                if (month > 1 && month < 13) {
                    count = arr[month - 2] + day;
                }
            } else {
                System.out.println("是平年");
                if (month > 1 && month < 13) {
                    count = arr[month - 2] + day - 1;
                }
            }
            System.out.println(count);
        } else {
            System.out.println("输入的日期格式与要求格式不符！！");
        }
    }
}

