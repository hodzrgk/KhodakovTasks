package khodakov;

public class Task1 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int m = Integer.parseInt(args[1]);
        int i = 0;

        while (true) {
            System.out.print(arr[i]);

            int j = (i+m)%(arr.length);
            if (j == 1) {
                break;
            } else {
                i=(j==0 ? n-1 : j-1);
            }
        }

    }
}
