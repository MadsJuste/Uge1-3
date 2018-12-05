/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uge1Dag1;

//a) Output til at starte med er tæt på at være i orden men efter den 3 thread kommer på begynder det at blive komplet random.
// dette er som forventet
/**
 *
 * @author Juste
 */
public class excercise2day1 {
    public static void main(String[]args) throws InterruptedException{
        createThread(100);
    }
    
    public static void createThread(int n) throws InterruptedException{
        for(int threadCount = 0; threadCount<n; threadCount++){
            Thread t1 = new Thread(new count(), "Thread " +threadCount);
            t1.start();
            Thread.sleep(2);
        }
    }
    
    static class count implements Runnable{
        private int counter;
        @Override
        public void run(){
            for(counter=1; counter < 100; counter++){
                System.out.println(Thread.currentThread().getName()+ ": " +counter);
                
            }
        }
    }
}
