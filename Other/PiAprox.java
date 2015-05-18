
package dailyprogrammerreddit;

import java.util.Random;
import java.util.Scanner;

public class PiAprox {
    public static void main(String[] args) {
        System.out.println("Enter the length of a square");
        Scanner vstup = new Scanner(System.in);
        double l = vstup.nextDouble();
        System.out.println("Enter the total number of shots");
        int sc = vstup.nextInt();
        Random r = new Random();
        int ic = 0;
        for(int i = 0; i<sc; i++){
            double x = r.nextDouble()*l;
            double y = r.nextDouble()*l;
            if(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))<=l){
                ic++;
            }
        }
        double id = (double) ic;
        System.out.println("Pi was approximated as: "+(id/sc)*4);
    }
}
