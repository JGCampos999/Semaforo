package ex1;

import java.util.concurrent.Semaphore;

import ex1.Controller;

public class View {

	public static Semaphore porta;

	public static void main(String[] args) {
		int pessoas = 1;
		porta = new Semaphore(pessoas);
		for (int i = 0; i <= 3; i++) {
			Thread passa = new Controller(i, porta);
			passa.start();
		}
	}

}
