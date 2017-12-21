import java.util.ArrayList;
import java.util.Iterator;

public class UNVReader {
    public static ArrayList<Double> getData(String filePath, int count) {
        ReadFile file = new ReadFile(filePath);
        int i;
        for (i = 0; i < 14; i++) { file.nextLine(); }
        i = 0;
        ArrayList<Double> datas = new ArrayList();
        while (i < count) {
            String[] t = file.nextLine().split(" ");
            int j;
            for (j = 0; j < t.length; j++) {
                if (!t[j].isEmpty()) {
                    String[] tt = t[j].split("E+");
                    datas.add(Double.parseDouble(tt[0]) * Math.pow(10, Integer.parseInt(tt[1])));
                    if (++i >= count) { break; }
                }
            }
        }
        return datas;
    }
}
