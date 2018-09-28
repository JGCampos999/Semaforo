package ex4;

import java.util.concurrent.Semaphore;

public class Control extends Thread {

	private int Op;
	private Semaphore controlaOp;
	private Semaphore OpSem;
	private Semaphore SemOp;
	private int Cod;
	private double Saldo;
	private double Val;

	public Control(int idThread, int Op, Semaphore OpSem, Semaphore controlaOp,
			double Valor, double Saldo) {
		this.Op = Op;
		this.OpSem = OpSem;
		this.SemOp = OpSem;
		this.controlaOp = controlaOp;
		this.Cod = idThread;
		this.Val = Valor;
		this.Saldo = Saldo;

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
		Saldo -= Val;
		System.out.println("Thread #" + Cod
				+ " Opera��o de Saque conclu�da com sucesso\nVoc� sacou: "
				+ Val + " da conta " + Cod + "\nO saldo � de:  " + Saldo);
	}

	public void Deposita() {
		Saldo += Val;
		System.out.println("Thread #"
				+ Cod
				+ " Opera��o de Dep�sito conclu�da com sucesso\nVoc� depositou: "
				+ Val + " na conta " + Cod + "\nO saldo � de: " + Saldo);
	}

}
