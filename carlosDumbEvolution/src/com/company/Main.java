//carlos
package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    static String goal = "evolutionforthewin";

    static int populationSize = 100;
    static ArrayList<Individual> population = new ArrayList<>();
    static Random r = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < populationSize; i++) {
            Individual ind = new Individual();
            ind.countFitness();
            population.add(ind);
        }

        for (int i = 0; i < 1000; i++) {
           ArrayList<Individual> offspring = new ArrayList<>();
           // TODO
           for (int j = 0; j < populationSize/2; j++){
               Individual p1 = selection();
               Individual p2 = selection();
               
               makeOffspring(offspring, p1, p2);
           }
           
           for(int j = 0; j < populationSize; j++){
               mutate(offspring.get(j));
               offspring.get(j).countFitness();
           }       
           
           population.addAll(offspring);
           Collections.sort(population);
           
           while(population.size() > populationSize){
               population.remove(population.size()-1);
           }
           
           System.out.println(population.get(0).gen + " " + population.get(0).fitness);
        }
    }

    static Individual selection(){ //tournament
          // TODO
          
        Individual i1 = population.get(r.nextInt(populationSize));  
        Individual i2 = population.get(r.nextInt(populationSize));  
        //return population.get(r.nextInt(populationSize));
        
        if (i1.fitness > i2.fitness)
            return i1;
        else
            return i2;

      
    }

    static void makeOffspring(ArrayList<Individual> children, Individual p1, Individual p2){

        Individual c1 = new Individual();
        Individual c2 = new Individual();
        // TODO
        
        c1.gen = p1.gen.substring(0,10) + p2.gen.substring(10);
        c2.gen = p2.gen.substring(0,10) + p1.gen.substring(10);
        
        

        children.add(c1);
        children.add(c2);
    }

    static void mutate(Individual i){

      // TODO
      
      int x = r.nextInt (goal.length());
      
      i.gen = i.gen.substring(0,x) + (char)(r.nextInt(26) + 'a') + i.gen.substring(x+1);

    }

}
