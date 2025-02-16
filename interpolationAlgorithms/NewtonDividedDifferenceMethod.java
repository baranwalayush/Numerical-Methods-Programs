class NewtonDividedDifferenceMethod{
    
    // Parameters
    private double x;
    private int sz;
    private double[] x_arr;
    private double[] y_arr;
    private double[][] y; 

    // Constructors
    public NewtonDividedDifferenceMethod(double x, double[] x_arr, double[] y_arr){
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

    public void generateDividedDiffTable(){

        for (int i=1; i<sz; i++) {
            for (int j = 0; j<sz - i; j++) {
                y[j][i] = (y[j][i - 1] - y[j + 1][i - 1]) / (x_arr[j] - x_arr[i + j]);
            }
        }
    }

    public void printDividedDifferenceTable(){
        
        System.out.println("The Divided Difference Table is: ");
        
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

        this.generateDividedDiffTable();

        for(int i=1; i<sz; i++){
            double temp = 1;

            for(int j=0; j<i; j++){
                temp *= (x - x_arr[j]);
            }

            value += temp * y[0][i];
        }

        return value;

    }

    // Main function
    public static void main(String[] args){
        
        double[] x_arr = {5, 7, 11, 13, 17};
        double[] y_arr = {150, 392, 1452, 2366, 5202};
        double x = 9;

        NewtonDividedDifferenceMethod interpolate = new NewtonDividedDifferenceMethod(x, x_arr, y_arr);
        double value = interpolate.findValue();

        // interpolate.printDividedDifferenceTable();
        
        System.out.println("Value at " + x + " is " + value);
    }
}