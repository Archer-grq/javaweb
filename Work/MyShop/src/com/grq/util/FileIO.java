package com.grq.util;

import java.io.*;

public class FileIO {


    public static void fileIO(String inPath,String inFileName,String outPath,String outFilename) throws Exception {

        File oPath=new File(outPath);
        File iPath=new File(inPath);
        if (!iPath.exists()){
            iPath.mkdir();
        }

        if (!oPath.exists()){
            oPath.mkdir();
        }

        FileInputStream fis=new FileInputStream(inPath+File.separator+inFileName);
        FileOutputStream fos=new FileOutputStream(outPath+File.separator+outFilename);
        byte[] bty = new byte[1024];
        int length =0;
        while((length=fis.read(bty))!=-1){
            fos.write(bty,0,length);
        }
        fos.close();
        fis.close();

    }
}
