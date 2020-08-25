package eleven.com;

import java.util.Scanner;

public class Main0825 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method(knapsackCapacity, volumes, values));
        }else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }

    public static int method(int knapsackCapacity, int[] volumes, int[] values) {
        int[] b = new int[volumes.length+1];
        int[] v = new int[values.length+1];
        int len = b.length;
        b[0] = 0;
        v[0] = 0;
        for (int i = 1; i < b.length; i++) {
            b[i] = volumes[i-1];
        }
        for (int i = 1; i < v.length; i++) {
            v[i] = values[i-1];
        }
        int[][] array = new int[len][knapsackCapacity+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < knapsackCapacity+1; j++) {
                if (i == 0) {
                    array[i][j] = 0;
                } else if (j == 0) {
                    array[i][j] = 0;
                }else {
                    if (j < b[i]) {
                        array[i][j] = array[i-1][j];
                    } else {
                        array[i][j] = Math.max(array[i-1][j], array[i-1][j-b[i]]+v[i]);
                    }
                }
            }
        }
        return array[len-1][knapsackCapacity];
    }
}
