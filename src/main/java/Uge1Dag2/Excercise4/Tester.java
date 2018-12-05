package Uge1Dag2.Excercise4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
C) de to tråde starter samtidet og så mens den ene tråd locker den ene List og sleeper så locker den anden tråd den anden List
    dette sker fordi den ene tråd tager fat i numbers først og den anden tager fat i Words og de blokere derfor for hinanden.7
D) for at løse problemet byttet jeg rund på den order som USER1 havde så de begge checkede numbers først og derefter words. dette gør at hvis den ene tråd starter
    så kan den anden ikke begynde da den allerede er locket.
*/
public class Tester {
  public static void main(String[] args) {
    DeadLockDetector DL = new DeadLockDetector();
    DL.start();
    try {
      ResourceContainer resources = new ResourceContainer();
      ResourceUser1 t1 = new ResourceUser1(resources);
      ResourceUser2 t2 = new ResourceUser2(resources);
      t1.start();
      t2.start();
          
      t1.join();
      t2.join();
      
      System.out.println("Done");
      System.out.println("Words produced: "+resources.getResourceWords().size());
      System.out.println("Numbers produced: "+resources.getResourceNumbers().size());
    } catch (InterruptedException ex) {
      Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
      static class DeadLockDetector extends Thread {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
    
        public void run() {
        while (true) {
          long[] threadIds = bean.findDeadlockedThreads();
          if(threadIds != null){
              System.out.println("Deadlock detected");
          }
        }
  }
}

}

