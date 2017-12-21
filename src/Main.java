import com.mathworks.toolbox.javabuilder.*;
import fftc.*;
import test.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static ArrayList c(String path, boolean sub) {
        // This is the path where the file's name you want to take.
        //String path = "D://time1";
        ArrayList t = GetFileName.getFilesName(path, sub);
        MWNumericArray input = null;
        ArrayList result = new ArrayList();
        try {
            //*/
            FFT fft = new FFT();
            int i =0;
            for (i = 0; i < t.size() ; i++) {
                ArrayList<Double> tt = UNVReader.getData(path + "//" + t.get(i), 100);
                input = new MWNumericArray(tt.toArray(), MWClassID.DOUBLE);
                result.add(fft.fftc(1, input, 100)[0]);
                //System.out.println(fft.fftc(1, input, 100)[0]);
            }
            /*/
            TEST test = new TEST();
            System.out.println(test.test(1, input, 100)[0]);
            //*/
        } catch (MWException e) {
            e.printStackTrace();
        } finally {
            if (input != null)
                MWArray.disposeArray(input);
        }

        /*/
        Iterator it = getFilesName(path, false).iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //*/
        return result;
    }
}
