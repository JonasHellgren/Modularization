package util.api;

import util.internal.AddHelper;

public class Calculator {

    AddHelper helper=new AddHelper();

    public int add(int a, int b) {
        return helper.add(a, b);
    }

        public int add(double a, double b) {
            return helper.add((int) a,(int) b);
        }
        
}
