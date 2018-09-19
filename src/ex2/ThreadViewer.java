package ex2;

import java.util.concurrent.Semaphore;

public class ThreadViewer {

	public static Semaphore Cruzar;

	public static void main(String[] args) {
		int QtdCarros = 1;
		String Caminho[] = new String[4];
		Caminho[0] = "a esquerda";
		Caminho[1] = "a direita";
		Caminho[2] = "baixo";
		Caminho[3] = "cima";
		Cruzar = new Semaphore(QtdCarros);

		for (int i = 0; i <= 3; i++) {
			Thread cruze = new ThreadController(i, Cruzar, Caminho);
			cruze.start();
		}
	}

}
