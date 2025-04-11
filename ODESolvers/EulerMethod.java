public class EulerMethod extends ODESolver {
    public EulerMethod(ODEFunction function) {
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
            y = computeChange(t, y, h);
            result[i] = y;
            t += h;
        }
        return result;
    }

    public double computeChange(double t, double y, double h){
        y = y + h * function.evaluate(t, y);
        return y;
    }
}
