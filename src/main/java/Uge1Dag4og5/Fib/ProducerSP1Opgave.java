/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juste
 */
public class ProducerSP1Opgave implements Runnable {
    
  BlockingQueue<Integer> Numbers;
  BlockingQueue<Integer> Results;
  boolean run = true;
  
  

    ProducerSP1Opgave(BlockingQueue<Integer> numbers, BlockingQueue<Integer> results) {
        this.Numbers = numbers;
        this.Results = results;
    }
    public void closeThread(){
        run = false;
    }
    
    @Override
    public void run() {
        int n = 0;
        int b = 0; 
        int a = 0;
        int temp;
        int d = 0;
        while (run) {
           if((n == 0) || (n==1)){
               try {
                   int c = Numbers.poll(10, TimeUnit.SECONDS);
                   Results.put(c);
                   n++;
               } catch (Exception ex) {
                   run = false;
                   Logger.getLogger(ProducerSP1Opgave.class.getName()).log(Level.SEVERE, null, ex);
               }
           }else{
            try {
               
                   a = Numbers.poll(10, TimeUnit.SECONDS);
                try{
                   d = Numbers.poll(10, TimeUnit.SECONDS);
                   b = a+d;
                }catch(Exception ex){
                   d = b; 
                   Logger.getLogger(ProducerSP1Opgave.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                temp = a + d;

                Results.put(temp);  
                n++;
             
        
             } catch(Exception ex) {
                run = false;
                Logger.getLogger(ProducerSP1Opgave.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }

    }
    }
    
}
