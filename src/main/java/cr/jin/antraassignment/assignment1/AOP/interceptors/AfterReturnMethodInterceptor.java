package cr.jin.antraassignment.assignment1.AOP.interceptors;

import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInterceptor;
import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInvocation;

import java.lang.reflect.Method;

public class AfterReturnMethodInterceptor implements MethodInterceptor {

    private final Object aspectInstance;
    private final Method aspectMethod;

    public AfterReturnMethodInterceptor(Object aspectInstance, Method aspectMethod) {
        this.aspectInstance = aspectInstance;
        this.aspectMethod = aspectMethod;
    }


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Exception {
        try {
            return methodInvocation.proceed();
        } finally {
            aspectMethod.setAccessible(true);
            aspectMethod.invoke(aspectInstance);
        }
    }
}
