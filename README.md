# ARSW-LAB-1

## Part I - Introduction to threads in JAVA

1. In agreement with the lectures, complete the classes CountThread, so that they define the life cycle of a thread that prints the numbers between A and B on the screen.
	```
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
	```
2. Complete the main method of the CountMainThreads class so that: 
	- Create 3 threads of type CountThread, assigning the first interval [0..99], the second [99..199], and the third [200..299]. 
	```
	public class CountThreadsMain {
    
	    public static void main(String a[]){
		Thread h1 = new Thread(new CountThread(0,99));
		Thread h2 = new Thread(new CountThread(99,199));
		Thread h3 = new Thread(new CountThread(200,299));

	    } 
	}
	```
	- Start the three threads with start(). Run and check the output on the screen. 
	```
	public class CountThreadsMain {
    
	    public static void main(String a[]){
		Thread h1 = new Thread(new CountThread(0,99));
		Thread h2 = new Thread(new CountThread(99,199));
		Thread h3 = new Thread(new CountThread(200,299));
		h1.start();
		h2.start();
		h3.start();

	    } 
	}
	```
	- Change the beginning with start() to run(). How does the output change? Why?

## Authors

[César González](https://github.com/csarssj) 

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/csarssj/ARSW-LAB-1/blob/master/LICENSE) file for details
