import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author yinxm
 * @version 1.0 2005/06/17  
 *
 * This class can take file's path and file's name;  
 * you must give the path where you want to take the file.  
 */
public class GetFileName {



    public static ArrayList<String> getFilesName(String path, boolean subFile){
        // get file list where the path has   
        File file = new File(path);
        // get the folder list   
        File[] array = file.listFiles();
        ArrayList<String> filesName = new ArrayList<String>();

        for(int i=0;i<array.length;i++){
            if(array[i].isFile()){
                if (array[i].getName().indexOf("unv") > 0 && array[i].getName().indexOf("~") == -1) {
                    filesName.add(array[i].getName());
                }
                /*/ only take file name
                System.out.println("^^^^^" + array[i].getName());
                // take file path and name   
                System.out.println("#####" + array[i]);
                // take file path and name   
                System.out.println("*****" + array[i].getPath());
                //*/
            }else if(subFile && array[i].isDirectory()){
                filesName.addAll(getFilesName(array[i].getPath(), subFile));
            }
        }
        Collections.sort(filesName);
        return filesName;
    }
}  