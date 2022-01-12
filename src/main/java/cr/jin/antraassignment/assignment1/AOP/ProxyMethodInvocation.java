package cr.jin.antraassignment.assignment1.AOP;

import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInterceptor;
import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInvocation;

import java.lang.reflect.Method;
import java.util.List;

public class ProxyMethodInvocation implements MethodInvocation {

    private final List<MethodInterceptor> methodInterceptorList;
    private final Object realInstance;
    private final Method method;
    private int idx;

    public ProxyMethodInvocation(List<MethodInterceptor> methodInterceptorList, Object realInstance, Method method) {
        this.methodInterceptorList = methodInterceptorList;
        this.realInstance = realInstance;
        this.method = method;
    }

    @Override
    public Object proceed() throws Exception {
        if (idx < methodInterceptorList.size()) {
            MethodInterceptor mi = methodInterceptorList.get(idx);
            idx++;
            return mi.invoke(this);
        } else {
            return method.invoke(realInstance);
        }
    }
}
