public abstract class ODESolver {
    protected ODEFunction function;

    public ODESolver(ODEFunction function) {
        this.function = function;
    }

    public abstract double[] solve(double t0, double y0, double tEnd, double h);
}
