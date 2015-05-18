package dailyprogrammerreddit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class I_195_MathDice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the parameters");
        String[] dices = in.nextLine().split(" ");
        System.out.println("-------------");
        int target = rand.nextInt(Integer.parseInt(dices[0].substring(2))) + 1;
        System.out.println("Target: " + target);
        System.out.println("-------------");
        ArrayList<Integer> list = new ArrayList<>();
        int nrolls = Integer.parseInt(dices[1].substring(0, dices[1].indexOf("d")));
        int size = Integer.parseInt(dices[1].substring(dices[1].indexOf("d") + 1));
        boolean succes = false;
        list.add(rand.nextInt(size) + 1);
        System.out.println("Rolling: " + list.get(0));
        int[] rolls = new int[nrolls];
        int index = -1;
        rolls[0] = list.get(0);
        index++;
        if (list.get(0) == target) {
            succes = true;
        }
        for (int i = 0; i < (nrolls - 1) && !succes; i++) {
            int listsize = list.size();
            int roll = rand.nextInt(size) + 1;
            rolls[i + 1] = roll;
            index++;
            System.out.println("Rolling: " + roll);
            for (int j = (int) Math.pow(2, i) - 1; j < listsize && !succes; j++) {
                if (list.get(j) + roll == target || list.get(j) - roll == target) {
                    succes = true;
                }
                list.add(list.get(j) + roll);
                list.add(list.get(j) - roll);
            }
        }
        System.out.println("-------------");
        if (succes) {
            //System.out.println(list);
            String out = rolls[0] + "";
            while (target != rolls[0]) {
                List<Integer> list2;
                if (succes) {
                    list2 = list.subList(((int) (Math.pow(2, index)) - 1), list.size()-1);
                    succes = false;
                } else {
                    list2 = list.subList(((int) (Math.pow(2, index)) - 1), (int) (Math.pow(2, index + 1)) - 2);
                }
                if (list2.indexOf(target) % 2 != 0) {
                    out += "-" + rolls[index];
                    target += rolls[index];
                } else {
                    out += "+" + rolls[index];
                    target -= rolls[index];
                }
                index--;
            }
            System.out.println(out);
        } else {
            System.out.println("Couldn't reach the target in " + nrolls + " rolls.");
        }
    }
}
