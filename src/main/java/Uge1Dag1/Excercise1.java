/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Uge1Dag1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juste
 */
public class Excercise1 {

    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 = new Thread(new count(), "Thread1");
        Thread t2 = new Thread(new printFive(), "Thread2");
        Thread t3 = new Thread(new tenUp(), "Thread3");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(10000);
        t3.interrupt();
        t3.join();
        t2.join();
        t1.join();
        
        System.out.println("Ending program");
        
    }
     
    static class count implements Runnable{
        private int counter;
        @Override
        public void run(){
            for(counter=0; counter < 1E9; counter++){
                System.out.println("Counter " +Thread.currentThread().getName()+ ": " +counter);
                
            }
        }
    }
    static class printFive implements Runnable{
        private int counter;
        @Override
        public void run(){
            for(counter = 0; counter <5; counter++){     
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Excercise1.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Counter " +Thread.currentThread().getName()+ ": " +counter);
            }
        }
    }
    
    static class tenUp implements Runnable{
        private int counter = 10;
        
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    Logger.getLogger(Excercise1.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("counter for thread " +Thread.currentThread().getName()+ ": " +counter);
                counter++;
            }
        }
    }
    
    
}
