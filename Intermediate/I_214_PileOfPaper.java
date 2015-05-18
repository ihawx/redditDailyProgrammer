package dailyprogrammerreddit;

import java.util.ArrayList;
import java.util.Scanner;

public class I_214_PileOfPaper {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the dimensions");
        String[] dims = input.nextLine().split(" ");
        int width = Integer.parseInt(dims[0]);
        int height = Integer.parseInt(dims[1]);

        ArrayList<Sheet> sheets = new ArrayList<>();

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                sheets.add(new Sheet(i, j, 0));
            }
        }
        String text = " ";
        int max = 0;
        while (text.length() > 0) {
            text = input.nextLine();
            if (text.length() > 0) {
                String[] params = text.split(" ");
                int c = Integer.parseInt(params[0]);
                int x = Integer.parseInt(params[1]);
                int y = Integer.parseInt(params[2]);
                int w = Integer.parseInt(params[3]);
                int h = Integer.parseInt(params[4]);
                if (w > width) {
                    w = width;
                }
                if (h > height) {
                    h = height;
                }
                if (c > max) {
                    max = c;
                }
                for (int i = x; i < x + w; i++) {
                    for (int j = y; j < h+y; j++) {
                        sheets.get(i + j * width).setColour(c);
                    }
                }
            }
        }
        int[] colcount = new int[max + 1];
        for (int i = 0; i < sheets.size(); i++) {
            colcount[sheets.get(i).getColour()]++;
            if (i % width == 0 && i > 0) {
                System.out.println("");
            }
            System.out.print(sheets.get(i).getColour() + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < colcount.length; i++) {
            System.out.println(i + ": " + colcount[i]);
        }

    }
}

class Sheet {

    int x, y, colour;

    Sheet(int x, int y, int colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    void setColour(int colour) {
        this.colour = colour;
    }

    int getColour() {
        return colour;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
