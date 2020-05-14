package eu.drham.util;


import org.bukkit.util.Vector;

public class Distance {

    private Vector A;
    private Vector B;
    public Distance(Vector A, Vector B){
        this.A = A;
        this.B = B;

    }

    public double getDistance(){
        Vector C = A.subtract(B);
        return C.length();
    }
}
