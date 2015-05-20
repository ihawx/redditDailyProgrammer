package dailyprogrammerreddit;

import java.util.ArrayList;
import java.util.Scanner;

public class I_215_SortingNetworks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the parameters of the network");
        String text = in.nextLine();
        int lines = Integer.parseInt(text.substring(0, text.indexOf(" ")));
        int comparators = Integer.parseInt(text.substring(text.indexOf(" ") + 1, text.length()));
        int[][] nums = new int[(int) Math.pow(2, lines)][lines];
        boolean[] succes = new boolean[(int) Math.pow(2, lines)];
        for (int i = 0; i < (int) Math.pow(2, lines); i++) {
            String help = Integer.toBinaryString(i);
            while (help.length() < lines) {
                help = "0" + help;
            }
            nums[i] = digitArray(help);
        }
        String[] comps = new String[comparators];
        System.out.println("Enter the comparators");
        for (int i = 0; i < comparators; i++) {
            comps[i] = in.nextLine();
        }
        for (int i = 0; i < (int) Math.pow(2, lines); i++) {
            SortingNetwork net = new SortingNetwork(lines, comparators, nums[i]);
            for (int j = 0; j < comparators; j++) {
                net.addComparator(Integer.parseInt(comps[j].substring(0, comps[j].indexOf(" "))), Integer.parseInt(comps[j].substring(comps[j].indexOf(" ") + 1, comps[j].length())));
            }
            nums[i] = net.returnArray();
            int first = nums[i][0];
            int count = 0;
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] != first) {
                    count++;
                    first = nums[i][j];
                }
            }
            if (count <= 1) {
                succes[i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < succes.length; i++) {
            if (succes[i] == true) {
                count++;
            }
        }
        if (count == (int) Math.pow(2, lines)) {
            System.out.println("Valid network");
        } else {
            System.out.println("Invalid network");
        }
    }

    public static int[] digitArray(String number) {
        int[] digs = new int[number.length()];
        for (int i = 0; i < digs.length; i++) {
            digs[i] = Integer.parseInt(number.substring(i, i+1));
        }
        return digs;
    }
}

class SortingNetwork {

    int nlines, ncomps;
    ArrayList<Comparator> comps = new ArrayList<>();
    int[] nums;

    SortingNetwork(int lines, int comps, int[] nums) {
        nlines = lines;
        ncomps = comps;
        this.nums = new int[lines];
        for (int i = 0; i < lines; i++) {
            this.nums[i] = nums[i];
        }
    }

    public void addComparator(int top, int bottom) {
        if (ncomps > 0) {
            comps.add(new Comparator(top, bottom, nums[top], nums[bottom]));
            comps.get(comps.size() - 1).compare();
            nums[comps.get(comps.size() - 1).top] = comps.get(comps.size() - 1).getTop();
            nums[comps.get(comps.size() - 1).bottom] = comps.get(comps.size() - 1).getBottom();
            ncomps--;
        }
    }

    public int[] returnArray() {
        return nums;
    }
}

class Comparator {

    int top, bottom;
    int tvalue, bvalue;

    Comparator(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    Comparator(int top, int bottom, int tvalue, int bvalue) {
        this.top = top;
        this.bottom = bottom;
        this.tvalue = tvalue;
        this.bvalue = bvalue;
    }

    public void compare() {
        if (bvalue > tvalue) {
            int help = bvalue;
            bvalue = tvalue;
            tvalue = help;
        }
    }

    public int getTop() {
        return tvalue;
    }

    public void setTop(int top) {
        tvalue = top;
    }

    public int getBottom() {
        return bvalue;
    }

    public void setBottom(int bottom) {
        bvalue = bottom;
    }
}
