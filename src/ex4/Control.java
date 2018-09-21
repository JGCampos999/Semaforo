package ex4;

import java.util.concurrent.Semaphore;

public class Control extends Thread {

	private int Op;
	private int idThread;
	private Semaphore controlaOp;
	private Semaphore OpSem;
	private Semaphore SemOp;
	private int Cod[] = new int[20];
	private double Saldo[] = new double[20];
	private double Val[] = new double[20];

	public Control(int idThread, int Op, Semaphore OpSem, Semaphore controlaOp,
			double Valor, double Saldo) {
		this.idThread = idThread;
		this.Op = Op;
		this.OpSem = OpSem;
		this.SemOp = OpSem;
		this.controlaOp = controlaOp;
		this.Cod[idThread] = idThread;
		this.Val[idThread] = Valor;
		this.Saldo[idThread] = Saldo;

	}

	public void run() {
		try {
			controlaOp.acquire();
			Controller();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			controlaOp.release();
		}
	}

	public void Controller() {
		if (Op == 1) {
			try {
				OpSem.acquire();
				Saca();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				OpSem.release();
			}
		} else {
			try {
				SemOp.acquire();
				Deposita();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				SemOp.release();
			}
		}
	}

	public void Saca() {
		Saldo[idThread] -= Val[idThread];
		System.out.println("Thread #" + (idThread + 1)
				+ " Operação de Saque concluída com sucesso\nVocê sacou: "
				+ Val[idThread] + " da conta " + Cod[idThread]
				+ "\nO saldo é de:  " + Saldo[idThread]);
	}

	public void Deposita() {
		Saldo[idThread] += Val[idThread];
		System.out
				.println("Thread #"
						+ (idThread + 1)
						+ " Operação de Depósito concluída com sucesso\nVocê depositou: "
						+ Val[idThread] + " na conta " + Cod[idThread]
						+ "\nO saldo é de: " + Saldo[idThread]);
	}

}
