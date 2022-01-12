package cr.jin.antraassignment.assignment1.AOP.interceptors;

import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInterceptor;
import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInvocation;

import java.lang.reflect.Method;

public class AfterMethodInterceptor implements MethodInterceptor {

    private final Object aspectInstance;
    private final Method aspectMethod;

    public AfterMethodInterceptor(Object aspectInstance, Method aspectMethod) {
        this.aspectInstance = aspectInstance;
        this.aspectMethod = aspectMethod;
    }


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Exception {
        aspectMethod.setAccessible(true);
        Object res = methodInvocation.proceed();
        aspectMethod.invoke(aspectInstance);
        return res;
    }
}
