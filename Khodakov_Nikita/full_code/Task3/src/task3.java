import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class task3 {

    public static void main(String[] args) throws IOException {
        File tests = new File(args[0]);
        File values = new File(args[1]);
        File report = new File(".\\report.json");

        BufferedReader reader = new BufferedReader(new FileReader(tests));
        BufferedWriter writer = new BufferedWriter(new FileWriter(report));

        String line = "";
        String tmpTests = "";
        String tmpValues = "";

        while((line = reader.readLine()) != null) {
            tmpTests+=line+"\n";
        }

        reader = new BufferedReader(new FileReader(values));

        while((line = reader.readLine()) != null) {
            tmpValues += line+"\n";
        }

        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("id\": \\d{1,}");
        Matcher matcher = pattern.matcher(tmpTests);
        while (matcher.find()) {
            list.add((tmpTests.substring(matcher.start(), matcher.end()).replaceAll("id\": ","")));
        }

        List<String> listId = new ArrayList<>();
        List<String> listValue = new ArrayList<>();
        Pattern pattern2 = Pattern.compile("id\": \\d{1,}");
        Matcher matcher2 = pattern2.matcher(tmpValues);
        while (matcher2.find()) {
            listId.add((tmpValues.substring(matcher2.start(), matcher2.end()).replace("id\": ","")));
        }

        Pattern pattern1 = Pattern.compile("value\": \".+\"");
        Matcher matcher1 = pattern1.matcher(tmpValues);

        while (matcher1.find()) {
            listValue.add(tmpValues.substring(matcher1.start(), matcher1.end()).replace("value\": ", "")
                    .replace("\"", ""));
        }

        for (int i=0; i < list.size(); i++) {
            for (int j=0; j < listId.size(); j++) {
                if(list.get(i).equals(listId.get(j))) {
                    tmpTests = tmpTests.replaceFirst("\"\"", "\"" + listValue.get(j) + "\"");
                }
            }
        }

        writer.write(tmpTests);
        System.out.println("File report.json downloads in \\Tasks_NT\\task3\\");

        reader.close();
        writer.close();

    }
}
