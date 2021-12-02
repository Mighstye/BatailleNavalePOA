package Client;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class MainClient {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		/*
		 * Il s'agit d'un code de base pour se connecter a un serveur via la technologie Socket
		 * 
		 * Ce programme va d�marr� un ListeningThread qui sera charg� d'afficher les messages recu du serveur.
		 * 
		 * Si l'utilisateur tape "quit" le programme s'arr�tera automatiquement.
		 */
		try {
			Socket s = new Socket("127.0.0.1", 1500);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			ListeningThread t = new ListeningThread(s);
			t.start();
			System.out.println("Connexion r�ussie!");
			Scanner sc=new Scanner(System.in);
			String message="";
			while (!message.equals("quit")) {
			message=sc.nextLine();
			out.println(message);
			}
			t.scan.close();
			t.stop();
			sc.close();
			s.close();
			} catch(Exception e) {
			// Traitement d'erreur
			}
	}
}