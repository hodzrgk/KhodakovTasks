import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));

        String line = "";
        String tmp = "";
        String[] arrStr1 = new String[3];
        String[] arrStr2 = new String[2];
        float[] arrFloat1 = new float[arrStr1.length];
        float x = 0.0F;
        float y = 0.0F;


        while((line = reader1.readLine()) != null) {
            tmp += line + " ";
        }
        arrStr1 = tmp.split(" ");

        for(int i=0; i<arrStr1.length; i++) {
            arrFloat1[i] = Float.parseFloat(arrStr1[i]);
        }

        reader1 = new BufferedReader(new FileReader(file2));
        double result = 0.0;

        while((line = reader1.readLine()) != null) {
            arrStr2 = line.split(" ");
            x = Float.parseFloat(arrStr2[0]);
            y = Float.parseFloat(arrStr2[1]);
            result = Math.pow((x - arrFloat1[0]), 2) + Math.pow((y - arrFloat1[1]), 2);

            if(result == Math.pow(arrFloat1[2], 2)) {
                System.out.println("0");
            } else if (result < Math.pow(arrFloat1[2], 2)) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }

    }
}
