package cr.jin.antraassignment.assignment1.AOP.interfaces;

public interface MethodInterceptor {
    Object invoke(MethodInvocation methodInvocation) throws Exception;
}
