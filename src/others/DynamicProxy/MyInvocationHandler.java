package others.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yuyang
 * @create 2019-07-03 9:55
 */
public class MyInvocationHandler implements InvocationHandler {
    //被代理对象，Object类型
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("准备向数据库中插入数据");
        Object returnvalue = method.invoke(target, args);
        System.out.println("插入数据库成功");

        return returnvalue;
    }

}