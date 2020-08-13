package edu.eci.arsw.threads;

/**
 *
 * @author Cesar Gonzalez
 */
public class CountThread implements Runnable{
	private int A;
	private int B;
	
	public CountThread(int A,int B) {
		this.A=A;
		this.B=B;
	}
	@Override
	public void run() {
		
		for(int i = A; i<B; i++) {
			System.out.println(i);
		}
		
	}
    
}
