import java.util.function.Function;

public class testFindDifferential {
    
    public static void main(String[] args) {
        Function<Double, Double> func = x -> x*x - 10*x + 9;
        double x = 1;
        
        // FDS with default x_del value
        findDifferential method1 = new ForwardDifferenceSystem(func, x);
        method1.find();
        method1.printResult();

        // FDS with user defined x_del value
        findDifferential method11 = new ForwardDifferenceSystem(func, x, 0.1);
        method11.find();
        method11.printResult();

        // BDS
        findDifferential method2 = new BackwardDifferenceSystem(func, x);
        method2.find();
        method2.printResult();

        // CDS
        findDifferential method3 = new CenralDifferenceSystem(func, x);
        method3.find();
        method3.printResult();

        // 3 Point FDS
        findDifferential method4 = new ThreePointForwardDifferenceSystem(func, x);
        method4.find();
        method4.printResult();

    }
}
