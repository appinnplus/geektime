import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class HelloXlassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = "";
        String fileName = path+name+".xlass";
        InputStream is = getClass().getResourceAsStream(fileName);
        if(is==null){
            return null;
        }
        try {
            int length = is.available();
            byte[] in = new byte[length];
            byte[] out = new byte[length];
            int index = 0;
            for(byte b: in){
                out[index++] = (byte)(255 - b);
            }
            return defineClass(name, out, 0, length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = new HelloXlassLoader().findClass("Hello");
            Object o = clazz.getDeclaredConstructor().newInstance();
            Method hello = clazz.getMethod("hello", null);
            hello.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
