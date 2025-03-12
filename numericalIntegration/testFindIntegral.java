package numericalIntegration;

import java.util.function.Function;

public class testFindIntegral {
    
    public static void main(String[] args) {
        Function<Double, Double> func = x -> x*x - 10*x + 9;
        double a = 3;
        double b = 5;

        // Euler Forward Method
        findIntegral method1 = new EulerForward(func, a, b);
        method1.find();
        method1.printResult();

        // Euler Backward Method
        findIntegral method2 = new EulerBackward(func, a, b);
        method2.find();
        method2.printResult();

        // Trapezoidal Method
        findIntegral method3 = new TrapezoidalRule(func, a, b);
        method3.find();
        method3.printResult();

        // Simpson's 1/3rd Rule
        findIntegral method4 = new Simpson1_3rd(func, a, b);
        method4.find();
        method4.printResult();

        // Simpson's 3/8th Rule
        findIntegral method5 = new Simpson3_8th(func, a, b);
        method5.find();
        method5.printResult();

    }
}
