//carlos ayala
package com.company;
import java.util.Random;

public class Individual implements Comparable<Individual> {

    Random r = new Random();
    public String gen;
    public double fitness ;

    public Individual() {

        gen = "";

        for (int i = 0; i < Main.goal.length() ; i++) {
            gen += (char)(r.nextInt(26) + 'a');
        }

    }

    void countFitness(){

        fitness = 0;
        
        for (int i =0; i< gen.length(); i++){
          fitness -= differenceFromGoal(i, gen.charAt(i));
        }
        // TODO

    }

    double differenceFromGoal(int position, char c){

//       if(Main.goal.charAt(position) == c){
//            return 0;
//        }
//            else{
//            return 1;
//        }

       return Math.pow((int)(Main.goal.charAt(position)) - c,2);

    }

    @Override
    public int compareTo(Individual o) {
        if (fitness < o.fitness)
            return 1;

        if (o.fitness == fitness){
            return 0;
        }
        return -1;
    }
}
