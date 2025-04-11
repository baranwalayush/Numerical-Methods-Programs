@FunctionalInterface
public interface ODEFunction {
    double evaluate(double t, double y);
}
