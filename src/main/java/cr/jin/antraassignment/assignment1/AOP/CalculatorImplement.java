package cr.jin.antraassignment.assignment1.AOP;

import cr.jin.antraassignment.assignment1.AOP.interfaces.Calculator;

public class CalculatorImplement implements Calculator {
    @Override
    public void run() {
        System.out.println("Calculator.run()");
    }
}
