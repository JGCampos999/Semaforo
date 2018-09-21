package ex2;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {
	private String Caminho[] = new String[4];
	private int Carro;
	private Semaphore Cruzar;

	public ThreadController(int Carro, Semaphore Cruzar) {
		this.Carro = Carro;
		this.Cruzar = Cruzar;
	}

	public void run() {
		Caminho[0] = "a esquerda";
		Caminho[1] = "a direita";
		Caminho[2] = "baixo";
		Caminho[3] = "cima";
		try {
			Cruzar.acquire();
			segueCaminho();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Cruzar.release();
		}
	}

	public void segueCaminho() {
		System.out.println("Carro #" + (Carro + 1) + " seguiu para " +Caminho[Carro]);
	}
}
