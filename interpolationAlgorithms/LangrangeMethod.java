class LangrangeMethod{

    // Parameters
    // x - value for which f(x) is to be interpolated
    // x_arr- array with x values
    // y_arr - array with corresponding y values, y = f(x)

    private double x;
    private double[] x_arr;
    private double[] y_arr;

    // Constructor
    public LangrangeMethod(double x, double[] x_arr, double[] y_arr){
        this.x = x;
        this. x_arr = x_arr;
        this.y_arr = y_arr;
    }

    // Implement Langrange Interpolation Algorithm
    public double findValue(){
        
        double value = 0;

        if(x_arr.length != y_arr.length){
            throw new IllegalArgumentException("Unequal Length: x_arr and y_arr must have same length.");
        }

        double sz = x_arr.length;

        for(int i=0; i<sz; i++){
            double numerator = 1;
            double denominatior = 1;

            for(int j=0;j<sz;j++){
                if(j==i){
                    continue;
                }
                numerator *= (x - x_arr[j]);
                denominatior *= (x_arr[i] - x_arr[j]);
            }

            value += (numerator / denominatior) * y_arr[i];
            
        }

        return value;

    }

    // Main Function
    public static void main(String[] args){
        double[] x_arr = {5, 7, 11, 13, 17};
        double[] y_arr = {150, 392, 1452, 2366, 5202};
        double x = 9;

        LangrangeMethod interpolate = new LangrangeMethod(x, x_arr, y_arr);
        double value = interpolate.findValue();

        System.out.println("Value at " + x + " is " + value);
    }
}