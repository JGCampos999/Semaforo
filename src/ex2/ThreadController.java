package ex2;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {
	private String Sentido[] = new String[4];
	private int Carro;
	private Semaphore Cruzar;

	public ThreadController(int Carro, Semaphore Cruzar, String Sentido[]) {
		this.Carro = Carro;
		this.Cruzar = Cruzar;
		this.Sentido = Sentido;
	}

	public void run() {
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
		try {
			System.out.println("Carro #" + (Carro + 1) + " seguiu para " + Sentido[Carro]);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
