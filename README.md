# ARSW-LAB-1

## Part I - Introduction to threads in JAVA

1. In agreement with the lectures, complete the classes CountThread, so that they define the life cycle of a thread that prints the numbers between A and B on the screen.
	```java
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
	```java
	public class CountThreadsMain {
    
	    public static void main(String a[]){
		Thread h1 = new Thread(new CountThread(0,99));
		Thread h2 = new Thread(new CountThread(99,199));
		Thread h3 = new Thread(new CountThread(200,299));

	    } 
	}
	```
	- Start the three threads with start(). Run and check the output on the screen. 
	```java
	public class CountThreadsMain {
    
	    public static void main(String a[]){
		Thread h1 = new Thread(new CountThread(0,99));
		Thread h2 = new Thread(new CountThread(99,199));
		Thread h3 = new Thread(new CountThread(200,299));
		h1.start();
		//h1.run();
		h2.start();
		//h2.run();
		h3.start();
		//h3.run();

	    } 
	}
	```
	- Change the beginning with start() to run(). How does the output change? Why?
	
	![image](https://github.com/csarssj/ARSW-LAB-1/blob/master/resources/IMG1.png)
	
	La diferencia es que cuando el programa llama al método start(), se crea un nuevo hilo y 
	el código dentro de run() se ejecuta en nuevo hilo mientras que si llama al método run() directamente
	Se creara un  nuevo hilo y el código dentro de run() se ejecutará en el hilo actual directamente.
	Por eso en el programa cuando implementamos run() se muestra en orden los numeros y cuando implementamos start()
	se ejecutan sin un orden especifico.

## Authors

[César González](https://github.com/csarssj) 

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/csarssj/ARSW-LAB-1/blob/master/LICENSE) file for details
