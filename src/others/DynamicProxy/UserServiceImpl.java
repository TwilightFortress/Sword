package others.DynamicProxy;

/**
 * @author yuyang
 * @create 2019-07-03 9:55
 */
public class UserServiceImpl implements IUserService {

    @Override
    public void add(String name) {
        System.out.println("向数据库中插入名为：  "+name+" 的用户");
    }

}