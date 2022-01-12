package cr.jin.antraassignment.assignment1.IoC;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private static final Map<String, Object> objMap = new HashMap<>();

    private static List<Class<?>> scan() {
        return Arrays.asList(EmployeeService1.class, EmployeeService2.class, MyService.class);
    }

    public static void init() throws Exception {
        List<Class<?>> classes = scan();
        for (Class<?> clazz: classes) {
            String name = clazz.getSimpleName();
            Object instance = clazz.getDeclaredConstructor().newInstance();
            objMap.put(name, instance);
        }

        for (Object instance: objMap.values()) {
            Class<?> clazz = instance.getClass();
            for (Constructor<?> constructor: clazz.getDeclaredConstructors()) {
                for (Field field: clazz.getDeclaredFields()) {
                    for (Annotation annotation: constructor.getDeclaredAnnotations()) {
                        if (annotation.annotationType() == Autowired.class) {
                            String name = field.getType().getSimpleName();
                            field.setAccessible(true);
                            field.set(instance, objMap.get(name));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        for (Object obj: objMap.values()) {
            System.out.println("Class: " + obj.getClass().getSimpleName() + "\n" + obj);
        }
    }
}

class MyService {
    private final EmployeeService1 ss1;
    private final EmployeeService2 ss2;

    @Autowired
    public MyService(EmployeeService1 ss1, EmployeeService2 ss2) {
        this.ss1 = ss1;
        this.ss2 = ss2;
    }

    public MyService() {
        ss1= null;
        ss2= null;
    }

    @Override
    public String toString() {
        return "ss1: " + ss1 +
                "\nss2: " + ss2 +
                "\n";
    }
}

class EmployeeService1 { }

class EmployeeService2 { }