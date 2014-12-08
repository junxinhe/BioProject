/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioproject;

/**
 *
 * @author junxin
 */
public class Score implements Comparable<Score>{
    int score;
    int seq1;
    int seq2;
    
    public Score(int score, int seq1, int seq2){
        this.score=score;
        this.seq1=seq1;
        this.seq2=seq2;
    }

    public int getScore() {
        return score;
    }

    public int getSeq1() {
        return seq1;
    }

    public int getSeq2() {
        return seq2;
    }

    @Override
    public int compareTo(Score other) {
        //if < return -1
        //if = return 0
        //if > return 1
        return (this.getScore()<other.getScore()?-1:(this.getScore()==other.getScore()?0:1));
    }
}
