import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) throws IOException {
        long sum = 0;
        long r = 0;
        int tmp;
        String line = "";
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Integer> list = new ArrayList<>();

        while((line = reader.readLine()) != null) {
            tmp = Integer.parseInt(line);
            list.add(tmp);
            sum+=tmp;
        }

        sum = sum/ list.size();
        for(int j = 0;j <list.size(); j++) {
            r += Math.abs(sum - list.get(j));
        }
        System.out.println(r);

    }
}

