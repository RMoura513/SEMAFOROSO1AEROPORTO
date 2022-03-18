package view;

import java.util.concurrent.Semaphore;

import controller.ControleAeroporto;

public class Main {

	public static void main(String[] args) {

		
		int permissao = 2;
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int id = 1; id < 13; id++) {
			ControleAeroporto controleaeroporto = new ControleAeroporto(id, semaforo);
			controleaeroporto.start();

	}

}
}