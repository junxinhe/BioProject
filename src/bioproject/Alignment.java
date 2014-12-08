/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioproject;

import static java.lang.Math.*;

/**
 *
 * @author junxin
 */
public class Alignment {

    String seq1;
    String seq2;
    String alignSeq1="";
    String alignSeq2="";
    int matrix[][];
    int match = 1;
    int mismatch = -1;
    int gap = -1;
    int score=0;

    public Alignment(String seq1, String seq2) {
        this.seq1 = seq1;
        this.seq2 = seq2;
        matrix = new int[seq1.length()][seq2.length()];
    }
    
    public void run(){
        alignment(seq1.length()-1,seq2.length()-1);
        trace();
    }

    public int alignment(int i, int j) {
        if (matrix[i][j] != 0) {
        } else if (i == 0 || j == 0) {
            matrix[i][j] = 0;
        } else {
            int a = alignment(i - 1, j - 1) + s(i, j);
            int b = alignment(i - 1, j) + gap;
            int c = alignment(i, j - 1) + gap;
            matrix[i][j] = max(a, max(b, max(c, 0)));
        }
        return matrix[i][j];
    }

    public int s(int i, int j) {
        if(seq1.charAt(i) =='-'|| seq2.charAt(j)=='-'){
            return 0;
        }   else if (seq1.charAt(i) == seq2.charAt(j)) {
            return match;
        } else {
            return mismatch;
        }
    }

    public void trace() {
        int x = seq1.length() - 1;
        int y = seq2.length() - 1;
        while (x > 0 && y > 0) {
            int m=max(matrix[x-1][y-1],max(matrix[x-1][y],matrix[x][y-1]));
            if(m==matrix[x-1][y-1]){
                alignSeq1=seq1.charAt(x)+alignSeq1;
                alignSeq2=seq2.charAt(y)+alignSeq2;
                x--;
                y--;
            }else if(m==matrix[x-1][y]){
                alignSeq1=seq1.charAt(x)+alignSeq1;
                alignSeq2="-"+alignSeq2;
                x--;
            }else{
                alignSeq1="-"+alignSeq1;
                alignSeq2=seq2.charAt(y)+alignSeq2;
                y--;
            }
        }
    }
    
    public String getAlignSeq1() {
        return alignSeq1;
    }

    public String getAlignSeq2() {
        return alignSeq2;
    }

    public void setScore(){
        for(int i=seq1.length()-1; i<0; i--){
            if (matrix[i][seq2.length()-1]>score){
                score=matrix[i][seq2.length()-1];
            }
        }
    }
    
    public int getScore(){
        return score;
    }
}
