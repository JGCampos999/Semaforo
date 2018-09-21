package ex4;

import java.util.concurrent.Semaphore;

public class Viewer {

	public static Semaphore OpSem;
	public static Semaphore controlaOp;
	public static void main(String[] args) {
		int QtdProcessos = 2;
		int Controlador = 1;
		OpSem = new Semaphore(Controlador);
		controlaOp = new Semaphore(QtdProcessos);
		for(int i = 0; i <= 19; i ++){
			int Op = (int)(1 + Math.random()* 2);
			double Valor = (int)(1 + Math.random() * 100);
			double Saldo = (int)(100 + Math.random() * 2000);
			Thread Banco = new Control(i, Op, OpSem, controlaOp, Valor, Saldo);
			Banco.start();
		}

	}

}
