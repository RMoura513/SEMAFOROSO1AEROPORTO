package controller;

import java.util.concurrent.Semaphore;

public class ControleAeroporto extends Thread{
	

	private int id;
	private Semaphore semaforo;
	
	public ControleAeroporto (int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
		
	}
	
	@Override
		public void run() {
		
		manobra();
		taxiar();
		pistas();
		
		try {
			semaforo.acquire();
			decolagem();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
		afastamento();

		}
	
	
	
	
	public void manobra() {
		int tempo;
		tempo = (int) ((Math.random()* 5)+ 3);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião #" + id + " Terminou de manobrar");
	}

	
	
	public void taxiar() {
		int tempo;
		tempo = (int) ((Math.random()* 6)+ 5);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião #" + id + " Terminou de taxiar");
	}

	public void pistas() {
		int n;
		n = (int) (Math.random()* 2);
		if (n == 0) {
			System.out.println("Avião #" + id + " está na pista Norte");
		}
		else {
			System.out.println("Avião #" + id + " está na pista Sul");
		}
	}
	
	
	public void decolagem() {
		int tempo;
		tempo = (int) ((Math.random()* 4)+ 1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião #" + id + " Decolou");
	}
	
	public void afastamento() {
		int tempo;
		tempo = (int) ((Math.random()* 6)+ 3);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("===========Avião #" + id + " se afastou==========");
	}
}
