import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class MyClassloader extends ClassLoader {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyClassloader myClassloader = new MyClassloader();
        Class<?> c1 = myClassloader.loadClass("Hello");
        Method method = c1.getMethod("hello");
        method.invoke(c1.getDeclaredConstructor().newInstance());
    }
}
