package old;

import java.util.Scanner;

public class EssayClass {
    public static Scanner keyboard = new Scanner(System.in);
    public static Essay essay1;

    public static void main(String[] args) {
        double g;
        double s;
        double l;
        double c;
        System.out.println("Enter Grammar Points:");
        g = keyboard.nextDouble();
        System.out.println("Enter Spelling Points:");
        s = keyboard.nextDouble();
        System.out.println("Enter Length Points:");
        l = keyboard.nextDouble();
        System.out.println("Enter Content Points:");
        c = keyboard.nextDouble();

        essay1 = new Essay(g,s,l,c);
        essay1.grade();

        System.out.println("The student's essay grade is: "+essay1.getScore()+"% "+essay1.getLetterGrade());
    }
}

class Essay extends GradedActivity {
    double grammer = 0; //30 points
    double spelling = 0; //20 points
    double length = 0; //20 points
    double content = 0; //30 points


    public Essay(double grammer, double spelling, double length, double content) {
        this.grammer = grammer;
        this.spelling = spelling;
        this.length = length;
        this.content = content;
    }

    public Essay() {

    }

    public void grade() {
        setScore(grammer,spelling,length,content);
    }

    public char getLetterGrade() {
        return super.getGrade();
    }

    public void setScore(double grammar, double spelling, double length, double content)
    {
        if(grammar+spelling+length+content > 100) {
            super.setScore(100);
        } else {
            super.setScore(grammar + spelling + length + content);
        }
    }

}

class GradedActivity {
    private double score;

    public void setScore(double s) {
        score = s;
    }

    public double getScore() {
        return score;
    }

    public char getGrade() {
        char letterGrade;

        if(score >= 90)
            letterGrade = 'A';
        else if (score >= 80)
            letterGrade = 'B';
        else if (score >= 70)
            letterGrade = 'C';
        else if (score >= 60)
            letterGrade = 'D';
        else
            letterGrade = 'F';

        return letterGrade;
    }

}