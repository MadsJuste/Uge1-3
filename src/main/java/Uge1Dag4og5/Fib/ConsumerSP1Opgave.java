/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juste
 */
public class ConsumerSP1Opgave implements Runnable {
    BlockingQueue<Integer> Results;
    boolean run = true;
    ConsumerSP1Opgave(BlockingQueue<Integer> results) {
       this.Results = results;
    }
    ArrayList<Integer> tempList = new ArrayList<>();

    @Override
    public void run() {
         while (run) {
            try {
             
             if(Results.isEmpty()){
               run = false;  
               int o = 0;
               for(int n = 0; n < tempList.size(); n++){
                   System.out.println("Fib number "+ n + " = "+ tempList.get(n));
                   o += tempList.get(n);
               }
               System.out.println("Total sum of all numbers = " + o);
             }else{
                 int p = Results.poll(1, TimeUnit.SECONDS);
                 System.out.println("Result of quary is: " + p );
                 tempList.add(p);
                 
             }
             } catch(Exception ex) {
                System.out.println("Array is empty");
                Logger.getLogger(ProducerSP1Opgave.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
    }
    
}
