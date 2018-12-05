/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uge1Dag1;

import java.util.logging.Level;
import java.util.logging.Logger;

//a) Im able to provoke a incorrect outcome
//b) with a thread.sleep on 5 the error takes some time to happen and seems to be clustered in the middel of the run, however with a thead.sleep on 500 it seems to occur more often
//c) easy piecy lemon squishy
//d) i've simply synchronized the next() method which seemed to be the simplest and a correct solution. synchronized on the next method renders it imposible for more than one thread to work on the object at a time.
// on second thought this might be the wrong selution considering that the class will than always be synchronized and that i might have other funktions that mihgt, in another version read but not write from it but is now unable to do it at the same time.
/**
 *
 * @author Juste
 */
public class excercise3day1{
    public static void main (String[]args) {
       
     
      runEven r = new runEven();
      Thread t1 = new Thread(r,"thread1");
      Thread t2 = new Thread(r,"thread2");  
      
      t1.start();
      t2.start();
      
    }
    
    static class runEven implements Runnable{
        int counter;
        final Even even = new Even();

        @Override
        public void run() {
           for (counter = 1; counter <1000; counter++){
               try {
                   Thread.sleep(5);
               } catch (InterruptedException ex) {
                   Logger.getLogger(excercise3day1.class.getName()).log(Level.SEVERE, null, ex);
               }
                System.out.println(Thread.currentThread().getName()+ ": " +even.next());
           }
        }
        
    
}
}
