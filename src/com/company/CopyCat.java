package com.company;
import java.io.File;
//import java.io.FileFilter;
//import java.io.FilenameFilter;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.util.*;

import org.apache.commons.io.FileUtils;

/*Verbesserungen:
-   Add mp3 > gewisser KB anzahl
-   Zusätzlich kopiere das Bild mit gröster KB anzahl dazu
-   Grafische Oberfläche?



 */
public class CopyCat {
        String dirCopyToName = "F:\\osuCopyMusic\\mp3";
        String dirSourceName = "F:\\osu!\\Songs";

        //Version 2
                                                                            /*
    public void listFiles(String dirName, List<File> files) {

        File dir = new File(dirName);

        FilenameFilter filteroni = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        File[] fList = dir.listFiles();
        String ext = "";
        if (fList != null) {
            for (File file : fList) {

                if (file.isFile()) {
                    File[] fList2 = dir.listFiles(filteroni);

                    for (File file2 : fList2){

                        files.add(file2);
                    }
                } else if (file.isDirectory()) {
                    listFiles(file.getAbsolutePath(), files);
                }

            }
       }
       }
                                                                             */
        //Version 2 Ende


        //Version 3 with org.apache.commons.io.FileUtils
        public void test() throws IOException{


            File dirS = new File(dirSourceName);
            File dirD = new File(dirCopyToName);


            Collection<File> files = FileUtils.listFiles(dirS, new String[] {"mp3"}, true);

            for(File file : files){
                System.out.println(file);

                if(file.isDirectory()){
                    System.out.println("Dir");
                }
                else if(file.exists())
                {
                    FileUtils.copyFileToDirectory(file, dirD);
                }

            }

        }
        //Ende V3


        //Liest aktuell alle Files aus C:\Temp aus.
        //Weitergehend nachdem alle Files in die ArrayList aufgenommen wurden, die verwerfen, welche nicht die Endung .txt haben

        public static void main(String[] args) throws IOException {



            //Version 2

        /*
            textFinder tf = new textFinder();
            ArrayList<File> fA = new ArrayList<>();
            tf.listFiles("C:\\temp", fA);
            System.out.println(fA);
        */
            //Version 2 Ende

            //V3
            CopyCat testcopy = new CopyCat();
            testcopy.test();
            //V3 Ende
        }




    }
