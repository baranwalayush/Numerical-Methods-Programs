public class MidpointMethod extends ODESolver {
    public MidpointMethod(ODEFunction function) {
        super(function);
    }

    @Override
    public double[] solve(double t0, double y0, double tEnd, double h) {
        int steps = (int) Math.ceil((tEnd - t0) / h);
        double[] result = new double[steps + 1];
        result[0] = y0;

        double t = t0;
        double y = y0;
        for (int i = 1; i <= steps; i++) {
            double k1 = function.evaluate(t, y);
            double k2 = function.evaluate(t + h / 2.0, y + h * k1 / 2.0);
            y = y + h * k2;
            t += h;
            result[i] = y;
        }
        return result;
    }
}
