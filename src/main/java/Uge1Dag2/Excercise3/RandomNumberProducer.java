package Uge1Dag2.Excercise3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RandomNumberProducer implements Runnable{

  public static final int MAX_NUMBERS_TO_PRODUCE = 100;
  public static final int MAX_RANDOM = 100;

  ArrayBlockingQueue<Integer> numbersProduced;

  public RandomNumberProducer(ArrayBlockingQueue<Integer> numbersProduced) {
    this.numbersProduced = numbersProduced;
  }
  
  @Override
  public void run() {
    for(int r = 0; r <100; r++ ){
       
         int  i = (int) ((Math.random() * MAX_RANDOM+1));
        try {
           
            numbersProduced.put(i);
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomNumberProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    //throw new UnsupportedOperationException("You nedd to complete the run() method for this to work");
    //Todo: Produce MAX_NUMBERS_TO_PRODUCE of random numbers between 0 and MAX_RANDOM and
    //      place the numbers in numbersProduced
  }
  
  //By now, you should know how to produce random numbers, but if not, use/run this as a guide
  public static void main(String[] args) {
    int MAX_RAND = 2;
    for (int i = 0; i < 10; i++) {
      int random = (int) ((Math.random() * MAX_RAND+1));
      System.out.println(random);
    }
  }

  
  
}
