package Uge1Dag2.Excercise1;

public class Tester {
  /*
    d) det tog ca 3 sekunder at lave run operationerene hvor det der imod tog 5.05 seckunder at kører .start() detter er dog fordi tråden sover i 5 sec før den resolver.
        sequential med run metoden er en hel del langsommer.
    */
  
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
    long start = System.nanoTime(); 
    TagCounter tc1 = new TagCounter("http://www.fck.dk");
    tc1.start();
    TagCounter tc2= new TagCounter("http://www.google.com");
    tc2.start();
    TagCounter tc3= new TagCounter("http://politiken.dk/");
    tc3.start();
   
    Thread.sleep(5000);

 


    System.out.println("Title: "+tc1.getTitle());
    System.out.println("Div's: "+tc1.getDivCount());
    System.out.println("Body's: "+tc1.getBodyCount());         
    
    
    System.out.println("Title: "+tc2.getTitle());
    System.out.println("Div's: "+tc2.getDivCount());
    System.out.println("Body's: "+tc2.getBodyCount());   
    
    System.out.println("Title: "+tc3.getTitle());
    System.out.println("Div's: "+tc3.getDivCount());
    System.out.println("Body's: "+tc3.getBodyCount());  
    
    
    long end = System.nanoTime();
    System.out.println("Time Sequential: "+(end-start));

  }
}
