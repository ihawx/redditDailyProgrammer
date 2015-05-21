package dailyprogrammerreddit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E_79_CountingInSteps {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] text = in.nextLine().split(" ");
        System.out.println(stepCount(Double.parseDouble(text[0]), Double.parseDouble(text[1]), Integer.parseInt(text[2])));
    }

    static public List<Double> stepCount(double a, double b, int steps) {
        List<Double> list = new ArrayList<>();
        double step = Math.abs(a - b) / (steps - 1);
        for (double i = a; (a > b ? i >= b : i <= b);
                i += (a > b) ? (-1 * step) : step) {
            list.add(i);
        }
        if (!list.contains(b)) {
            list.add(b);
        }
        return list;
    }
}
