class NewtonForwardDifferenceMethod{
    
    // Only applicable for equal interval data points
    // Parameters
    private double x;
    private int sz;
    private double[] x_arr;
    private double[] y_arr;
    private double[][] y; 

    // Constructors
    public NewtonForwardDifferenceMethod(double x, double[] x_arr, double[] y_arr){
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

    public void generateForwardDiffTable() {

        for (int i=1; i < sz; i++) {
            for (int j = 0; j<sz-1; j++) {
                y[j][i] = (y[j + 1][i - 1] - y[j][i - 1]);
            }
        }
    }

    public void printForwardDifferenceTable() {
        
        System.out.println("The forward Difference Table is: ");
        
        int n = x_arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(y[i][j] + "\t ");
            }
            System.out.println("");
        }
    }

    public double findValue(){

        double value = y[0][0];

        if(x_arr.length != y_arr.length){
            throw new IllegalArgumentException("Unequal Length: x_arr and y_arr must have same length.");
        }

        this.generateForwardDiffTable();

        double h = (x_arr[1] - x_arr[0]);
        double p = (x - x_arr[0]) / h;
        long fact = 1;

        for(int i=1; i<sz; i++) {

            double temp = 1;
            for(int j=0; j<i; j++) {
                temp *= (p-j);
            }

            value += (temp * y[0][i]) / fact ;

            fact *= (i+1);
        }

        return value;

    }

    // Main function
    public static void main(String[] args){
        
        double[] x_arr = {0, 1, 2, 3};
        double[] y_arr = {1, 2, 1, 10};
        double x = 4;

        NewtonForwardDifferenceMethod interpolate = new NewtonForwardDifferenceMethod(x, x_arr, y_arr);
        double value = interpolate.findValue();

        interpolate.printForwardDifferenceTable();
        
        System.out.println("Value at " + x + " is " + value);
    }
}