/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * @author Juste
 */
public class MainSP1Opgave {
    
    public static void main(String[] args){    
    ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(11);
    numbers.add(4);
    numbers.add(5);
    numbers.add(8);
    numbers.add(12);
    numbers.add(21);
    numbers.add(22);
    numbers.add(34);
    numbers.add(35);
    numbers.add(36);
    numbers.add(37);
    numbers.add(42);
    ArrayBlockingQueue<Integer> results = new ArrayBlockingQueue(10);
    
    
    ExecutorService es = Executors.newCachedThreadPool();
    

    es.execute(new ProducerSP1Opgave(numbers, results)); 
    es.execute(new ProducerSP1Opgave(numbers, results)); 
    es.execute(new ProducerSP1Opgave(numbers, results)); 
    es.execute(new ProducerSP1Opgave(numbers, results)); 
    es.execute(new ConsumerSP1Opgave (results)); 
    es.shutdown();
    }
}
