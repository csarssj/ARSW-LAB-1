/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.util.Scanner;

/**
 * Cesar Gonzalez
 */
public class Control extends Thread {
    
    private final static int NTHREADS = 3;
    private final static int MAXVALUE = 30000000;
    private final static int TMILISECONDS = 5000;

    private final int NDATA = MAXVALUE / NTHREADS;

    private PrimeFinderThread pft[];
    private boolean running;
    
    private Control() {
        super();
        this.pft = new  PrimeFinderThread[NTHREADS];

        int i;
        for(i = 0;i < NTHREADS - 1; i++) {
            PrimeFinderThread elem = new PrimeFinderThread(i*NDATA, (i+1)*NDATA);
            pft[i] = elem;
        }
        pft[i] = new PrimeFinderThread(i*NDATA, MAXVALUE + 1);
    }
    
    public static Control newControl() {
        return new Control();
    }

    @Override
    public void run() {
        for(int i = 0;i < NTHREADS;i++ ) {
            pft[i].start();
        }
        while(true) {
	        try {
				Thread.sleep(TMILISECONDS);
				pause();
				for(int i = 0;i < NTHREADS;i++) {
					System.out.println("Primos encontrados: "+pft[i].getPrimes().size());
				}
				System.out.println();
	            System.out.println("Enter para continuar:");
	            System.out.println();
	            Scanner al = new Scanner(System.in);
	            if(al.nextLine()!=null) {
	            	pass();
	            }
	            
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
       }    
        
    }
    public void pause() {
    	for(int i = 0;i < NTHREADS;i++ ) {
            pft[i].pause();
        }
    }
    public void pass() {
    	for(int i = 0;i < NTHREADS;i++ ) {
            pft[i].pass();
        }
    }
   
    
}
