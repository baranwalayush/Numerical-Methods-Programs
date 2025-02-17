class GaussBackwardCentralDifferenceMethod{
    
    // Works better for interpolating point lying in between (central) of total data points
    // Only applicable for equal interval data points
    // Parameters
    private double x;
    private int sz;
    private double[] x_arr;
    private double[] y_arr;
    private double[][] y; 

    // Constructors
    public GaussBackwardCentralDifferenceMethod(double x, double[] x_arr, double[] y_arr){
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
    
    private void generateDiffTable() {

        for (int i=1; i < sz; i++) {
            for (int j = 0; j<sz-1; j++) {
                y[j][i] = (y[j + 1][i - 1] - y[j][i - 1]);
            }
        }
    }

    public void printDifferenceTable() {
        
        System.out.println("The Gauss Backward Difference Table is: ");
        
        int n = x_arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(y[i][j] + "\t ");
            }
            System.out.println("");
        }
    }

    private double calculate(double p, int n) {
	
	    double temp = p;

	    for(int i=1; i<n; i++) {
		
		    if(i % 2 == 1){
			temp *= (p + ((i + 1) / 2));
		    }
		    else{
			temp *= (p - (i / 2));
		    }
	    }

	    return temp;
    } 

    public double findValue(){

        // Assuming the centre data point to x0

        double value = y[(int)(sz / 2)][0];

        if(x_arr.length != y_arr.length){
            throw new IllegalArgumentException("Unequal Length: x_arr and y_arr must have same length.");
        }

        this.generateDiffTable();

        double h = (x_arr[1] - x_arr[0]);
        double p = (x - x_arr[(int) (sz / 2)]) / h;
	
        if(p<-1 || p>0) {
            System.out.println("p = " + p);
            System.out.println("Gauss Backward Central Interpolation Method is not preferred for these data points as p is not between -1 and 0. The final result may not be accurate.");
        }

        long fact = 1;
	    int count = 1;

        for(int i=1; i<sz; i++) {

            double temp = calculate(p, i);

            value += (temp * y[(int)(sz / 2) - count][i]) / fact ;

            if(i % 2 == 0){
                count++;
            }

            fact *= (i + 1);
        }

        return value;

    }

    // Main function
    public static void main(String[] args){
        
        double[] x_arr = {1901, 1911, 1921, 1931, 1941, 1951};
        double[] y_arr = {12, 15, 20, 27, 39, 52};
        double x = 1936;

        GaussBackwardCentralDifferenceMethod interpolate = new GaussBackwardCentralDifferenceMethod(x, x_arr, y_arr);
        double value = interpolate.findValue();

        interpolate.printDifferenceTable(); // Print Difference Table
        
        System.out.println("Value at " + x + " is " + value);
    }
}
