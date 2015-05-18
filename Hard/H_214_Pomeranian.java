package dailyprogrammerreddit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class H_214_Pomeranian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            in = new Scanner(new FileReader("challenge2.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(H_214_Pomeranian.class.getName()).log(Level.SEVERE, null, ex);
        }
        int not = Integer.parseInt(in.nextLine()); // number of treats
        double[] x = new double[not]; //x coord of treats
        double[] y = new double[not]; //y coord of treats
        double nx = 0.5;
        double ny = 0.5; // starting pos
        double lop = 0; // length of path
        for (int i = 0; i < not; i++) {
            String line = in.nextLine();
            x[i] = Double.parseDouble(line.substring(0, line.indexOf(" ")));
            y[i] = Double.parseDouble(line.substring(line.indexOf(" ")));
        }
        System.out.println("Data loaded");
        int[] indexy = new int[not];
        for (int i = 0; i < not; i++) {
            indexy[i] = -1;
        }
        for (int i = 0; i < not; i++) {
            double distance = Double.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < not; j++) {
                if ((Math.sqrt(Math.pow(nx - x[j], 2) + Math.pow(ny - y[j], 2))) < distance) {
                    boolean ga = true;
                    for (int k = 0; k < i; k++) {
                        if (j == indexy[k]) {
                            ga = false;
                        }
                    }
                    if (ga) {
                        distance = Math.sqrt(Math.pow(nx - x[j], 2) + Math.pow(ny - y[j], 2));
                        index = j;
                    }
                }
            }
            lop += Math.sqrt(Math.pow(nx - x[index], 2) + Math.pow(ny - y[index], 2));
            nx = x[index];
            ny = y[index];
            indexy[i]=index;
        }

        System.out.println(lop);
    }
}
