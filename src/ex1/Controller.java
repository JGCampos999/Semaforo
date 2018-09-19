package ex1;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
	private int numPessoa;
	private Semaphore porta;
	private int Vet[] = new int[4];

	public Controller(int numPessoa, Semaphore porta) {
		this.numPessoa = numPessoa;
		this.porta = porta;
	}

	public void run() {
		while (Vet[numPessoa] < 200) {
			passaPorta();
		}
	}

	public void passaPorta() {
		Vet[numPessoa] += (int) (4 + Math.random() * 3);
		if (Vet[numPessoa] > 199) {
			try {
				porta.acquire();
				System.out.println((numPessoa + 1) + "� pessoa chegou na porta");
				int tempoDormir = ((int) (1 + Math.random() * 2) * 1000);
				Thread.sleep(tempoDormir);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println((numPessoa + 1) + "� pessoa cruzou a porta");
				porta.release();
			}
		}

	}
}
