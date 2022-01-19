package cr.jin.antraassignment.assignment1.AOP.interceptors;

import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInterceptor;
import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInvocation;

import java.lang.reflect.Method;

public class AroundMethodInterceptor implements MethodInterceptor {

    private final Object aspectInstance;
    private final Method aspectMethod;

    public AroundMethodInterceptor(Object aspectInstance, Method aspectMethod) {
        this.aspectInstance = aspectInstance;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Exception {
        aspectMethod.setAccessible(true);
        return aspectMethod.invoke(aspectInstance, methodInvocation);
    }
}
