class NewtonBackwardDifferenceMethod{
    
    // Only applicable for equal interval data points
    // Parameters
    private double x;
    private int sz;
    private double[] x_arr;
    private double[] y_arr;
    private double[][] y; 

    // Constructors
    public NewtonBackwardDifferenceMethod(double x, double[] x_arr, double[] y_arr){
        this.x = x;
        this.x_arr = x_arr;
        this.y_arr = y_arr;
        this.sz = x_arr.length;

        y = new double[sz][sz];

        for(int i=0; i<sz; i++){
            y[i][0] = y_arr[i];
        }
    }

    // Implement Algorithm

    public void generateBackwardDiffTable() {

        for (int i=1; i<sz; i++) {
            for (int j=sz-1; j>0; j--) {
                y[j][i] = (y[j][i - 1] - y[j - 1][i - 1]);
            }
        }
    }

    public void printBackwardDifferenceTable() {
        
        System.out.println("The Backward Difference Table is: ");
        
        int n = x_arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(y[i][j] + "\t ");
            }
            System.out.println("");
        }
    }

    public double findValue(){

        double value = y[sz-1][0];

        if(x_arr.length != y_arr.length){
            throw new IllegalArgumentException("Unequal Length: x_arr and y_arr must have same length.");
        }

        this.generateBackwardDiffTable();

        double h = (x_arr[1] - x_arr[0]);
        double p = (x - x_arr[sz-1]) / h;
        long fact = 1;

        for(int i=1; i<sz; i++) {

            double temp = 1;
            for(int j=0; j<i; j++) {
                temp *= (p + j);
            }

            value += (temp * y[sz-1][i]) / fact ;

            fact *= (i+1);
        }

        return value;

    }

    // Main function
    public static void main(String[] args){
        
        double[] x_arr = {0, 1, 2, 3};
        double[] y_arr = {1, 2, 1, 10};
        double x = 4;

        NewtonBackwardDifferenceMethod interpolate = new NewtonBackwardDifferenceMethod(x, x_arr, y_arr);
        double value = interpolate.findValue();

        interpolate.printBackwardDifferenceTable();
        
        System.out.println("Value at " + x + " is " + value);
    }
}
