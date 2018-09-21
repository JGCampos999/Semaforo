package ex2;

import java.util.concurrent.Semaphore;

public class ThreadView {

	public static Semaphore Cruzar;

	public static void main(String[] args) {
		int QtdCarros = 1;
		Cruzar = new Semaphore(QtdCarros);
		for (int i = 0; i <= 3; i++) {
			Thread cruze = new ThreadController(i, Cruzar);
			cruze.start();
		}
	}

}

