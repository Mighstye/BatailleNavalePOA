package Server.gestion;

import java.util.Timer;

public class ThreadGestion extends Thread{
	/*
	 * Ce thread est demarr� au d�marrage du serveur, il d�marre un "GameStartTimer()" toutes les 10 secondes
	 */
	public void run() {
		Timer timer = new Timer();
		timer.schedule(new GameStartTimer(), 0, 10000);
	}
}
