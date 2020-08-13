package edu.eci.arsw.threads;

/**
 *
 * @author Cesar Gonzalez
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        Thread h1 = new Thread(new CountThread(0,99));
        Thread h2 = new Thread(new CountThread(99,199));
        Thread h3 = new Thread(new CountThread(200,299));
        h1.run();
        h2.run();
        h3.run();
    
    } 
}
