package cr.jin.antraassignment.assignment1.AOP;

import cr.jin.antraassignment.assignment1.AOP.interfaces.Calculator;

import java.lang.reflect.Proxy;

public class AOPTest {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImplement();
        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                calculator.getClass().getClassLoader(),
                new Class[] {Calculator.class},
                new ReflectiveInvocationHandler(calculator, new CalculatorAspect())
        );
        proxy.run();
    }
}