package com.company;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import static org.apache.commons.io.FileUtils.sizeOf;


//import java.io.FileFilter;
//import java.io.FilenameFilter;
//import java.lang.reflect.Array;

/*Verbesserungen:
-   Add mp3 > gewisser KB anzahl
-   Zusätzlich kopiere das Bild mit größter KB anzahl dazu
-   Grafische Oberfläche?
-   Picklist?
???




 */
public class CopyCat {

    //"F:\\osuCopyMusic\\mp3"
    //"F:\\osu!\\Songs"
       private String dirCopyToName ="C:\\temp\\copytest";
       private String dirSourceName ="C:\\temp\\kek";


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

    private void guiTest(){
        JFrame meinFrame = new JFrame("Example");
        meinFrame.setSize(400,400);

        JPanel panel = new JPanel();
        JButton buttonOne = new JButton("KLick");
        panel.add(buttonOne);
        meinFrame.add(panel);
        meinFrame.setVisible(true);

        buttonOne.addActionListener(this::actionPerformed);
    }

    private void actionPerformed (ActionEvent ae){
        ae.getSource();
        System.out.println("Yo");
    }



    public String getDirCopyToName(){
        return dirCopyToName;
    }

    public void setDirCopyToName(String sdctn){
        this.dirCopyToName = sdctn;
    }

        //Version 3 with org.apache.commons.io.FileUtils
        private void test() throws IOException{

            File dirS = new File(dirSourceName);
            File dirD = new File(dirCopyToName);


            //mp3
            Collection<File> files = FileUtils.listFiles(dirS, new String[] {"txt", "jpg"}, true);

            for(File file : files){
                System.out.println(file);

                if(file.isDirectory()){
                    System.out.println("Dir");
                }
                else if(file.exists())
                {
                    System.out.println(sizeOf(file));
                    if(sizeOf(file)< 40000) {
                        FileUtils.copyFileToDirectory(file, dirD);
                    }
                }

            }

        }
    //Ende V3


        //Liest aktuell alle Files aus C:\Temp aus.
        //Weitergehend nachdem alle Files in die ArrayList aufgenommen wurden, die verwerfen, welche nicht die Endung .txt haben

        public static void main(String[] args) {//throws IOException {



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
            //testcopy.test();
            testcopy.guiTest();
            //V3 Ende
        }




    }
