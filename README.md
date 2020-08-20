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

## Snake

Accordingly, and using the game logic, identify and write clearly (ANSWERS.txt file)
1. Possible race conditions
	When two snakes eat a mouse at the same time
	When two snakes take a power  at the same time
	Probability when two or more snakes pass through the same cell
2. An incorrect or inappropriate use of collections, considering its concurrent handling(For this increase the game speed and execute it multiples times until an error has been raised).
	Using linkedlist throws a "ConcurrentModificationException" error and is possibly not the best solution for handling concurrency
3. Unnecessary use of active waits

	wait for the snakes to die
4As you can see, the game is incomplete. Write code in order to implement functionallities through buttons in the GUI to start / Pause / Resume the game: start the game if it has not started, Pause the game if it is on, Resume the game if it is suspended. Keep in mind:
When the game has been paused, in some point of the screen you have to show 
the longest snake
The worst snake:(the first snake  dead): 
   - Pause:
	```java
	pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i != MAX_THREADS; i++ ) {
					snakes[i].pause();
				}
				int longest = 0;
				int first = 0;
				for(int i = 0; i != MAX_THREADS; i++) {
					if(longest < snakes[i].getBody().size()) {
						longest = snakes[i].getBody().size();
					}
					if(snakes[i].isSnakeEnd() && !dead) {
						first = snakes[i].getIdt();
						dead =  true;
					}
				}
				System.out.println("La snake más larga es" + String.valueOf(longest));
				String res = (dead) ? "primera serpiente en morir fue" + String.valueOf(first) : "No ha muerto nadie";
				System.out.println(res);
				
			}
    	});
	```
   - Start: 
   	```java
   	ini.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(!start){
    				for (int i = 0; i != MAX_THREADS; i++) {
    					thread[i].start();
    				}
    			}start = true;
            }'S
        });
	```
    - Resume: 
   	```java
   	resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i != MAX_THREADS; i++ ) {
					snakes[i].resume();
				}
				
			}
    	});
	```

Remember that the pause of the snakes are not instantanious, and you have to guarantee that all the information showed is consistent


## Authors

[César González](https://github.com/csarssj) 

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/csarssj/ARSW-LAB-1/blob/master/LICENSE) file for details

## NOTE
 
Tuve un error con VisualVM en eclipse el cual no pude solucionar, voy a probar en otras IDE'S´para proximos laboratorios
