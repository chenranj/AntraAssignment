package cr.jin.antraassignment.assignment1.AOP;

import cr.jin.antraassignment.assignment1.AOP.annotations.*;

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
    public void aroundLogic() {
        System.out.println("This is around.");
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
