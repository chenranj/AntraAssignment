package cr.jin.antraassignment.assignment1.AOP;

import cr.jin.antraassignment.assignment1.AOP.annotations.*;
import cr.jin.antraassignment.assignment1.AOP.interfaces.MethodInvocation;

public class CalculatorAspect {


    @Before
    public void beforeLogic() {
        System.out.println("This is before.");
    }

    @After
    public void afterLogic() {
        System.out.println("This is after.");
    }

    @Around
    public Object aroundLogic(MethodInvocation mi) throws Exception {
        System.out.println("This is around before");
        Object res = mi.proceed();
        System.out.println("This is around after");
        return res;
    }

    @AfterThrow
    public void afterThrowLogic() {
        System.out.println("This is afterThrow.");
    }

    @AfterReturn
    public void afterReturnLogic() {
        System.out.println("This is afterReturn.");
    }

}
