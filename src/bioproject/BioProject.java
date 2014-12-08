/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junxin
 */
public class BioProject {

    String filename;
    String[] content;
    List<Score> score;

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            BioProject bp=new BioProject("seqs.txt");
        } catch (IOException ex) {
            Logger.getLogger(BioProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    BioProject(String filename) throws FileNotFoundException, IOException {
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if(line.length()>0&&line.charAt(0)=='>'){
                stringBuffer.append("\n");
            }
            stringBuffer.append(line);
        }
        fileReader.close();
        content=stringBuffer.toString().split("\n");
        //score=new int[(content.length)*(content.length-1)/2];
    }
    
    public int alignment(String seq1, String seq2){
        int s=0;
        
        return s;
    }
}
