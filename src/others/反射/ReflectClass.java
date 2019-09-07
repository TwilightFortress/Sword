package others.反射;

import sun.rmi.runtime.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yuyang
 * @create 2019-08-29 14:03
 */
public class ReflectClass {
    private final static String TAG = "peter.log.ReflectClass";

    // 创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.android.peter.reflectdemo.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("反射1");
            book.setAuthor("yu");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("com.android.peter.reflectdemo.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class, String.class);
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("反射2", "yu");
            Book book = (Book) objectBook;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.android.peter.reflectdemo.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.android.peter.reflectdemo.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook, 0);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}