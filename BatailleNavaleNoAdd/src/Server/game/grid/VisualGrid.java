package Server.game.grid;

import java.util.Arrays;

import Server.game.bateaux.Bateau;
import Server.utils.FacingDirection;

public class VisualGrid {
	/*
	 * La VisualGrid fonctionne comme l'Objet Grid a la difference que ces un tableau de characters
	 * Aucun calcul d'attaque ou autre est effectu� sur cette grille, elle est juste modifi� en cons�quence pour que le joueur est une grille visuel de sa situation.
	 * 
	 * VisualOwnGrid = Grille du joueur sur lequel il verra ses bateaux et les endroits o� il a �tait attaqu�.
	 * VisuelEnnemyGrid = Grille ou le joueur peut voir o� il a attaquait et si les attaques ont �t� fructueuse ou non.
	 * 
	 * Cette objets possede les methodes Getters et Setters habituelles et quelques methodes customs
	 */
	private char[][] visualOwnGrid= new char[10][10];
	private char[][] visualEnnemyGrid = new char[10][10];
	
	/*
	 * ~ : Case d'eau (Encore inconnue)
	 * 
	 * O : Case d'eau (D�j� tir� ici)
	 * X : Case touch� !
	 * 
	 * < : Arri�re d'un bateau horizontal.
	 * > : Avant d'un bateau horizontal.
	 * = : Corps d'un bateau simple.
	 * A : Avant d'un bateau vertical.
	 * V : Arri�re d'un bateau vertical.
	 * | : Corps d'un bateau vertical.
	 * 
	 */
	
	public VisualGrid() {
		for(char[] g : this.visualOwnGrid) {
			Arrays.fill(g, '~');
		}
		for(char[] g : this.visualEnnemyGrid) {
			Arrays.fill(g, '~');
		}
	}
	/*
	 * Permet de changer un charact�re par un autre sur la VisualOwnGrid
	 */
	public void changeCharOnOwnVisualGrid(int x, int y, char c) {
		this.visualOwnGrid[x][y] = c;
	}
	/*
	 * Permet de changer un charact�re par un autre sur la VisualEnnymyGrid
	 */
	public void changeCharOnEnnemyVisualGrid(int x, int y, char c) {
		this.visualEnnemyGrid[x][y] = c;
	}

	public char[][] getVisualOwnGrid() {
		return this.visualOwnGrid;
	}
	
	public char[][] getVisualEnnemyGrid() {
		return this.visualEnnemyGrid;
	}
	/*
	 * Meme methode que pour l'objet Grid, a la diff�rence qu'aucune verification n'est faite ici.
	 * En effet, si un utilisateur rentre des mauvaises coordonn�es, alors l'objet Grid renverra deja la WrondPlacementException qui empechera que cette methode ici soit utilis�
	 * Ainsi, cette methode n'est utilis� que si la bateau est plac� sur l'objet Grid avec succ�s d'abord, donc une seconde verification n'est pas necessaire.
	 */
	public void placeVisualBoatOnGrid(int ligne, int colonne, Bateau boat, FacingDirection direction) {
		switch(direction) {
		case NORTH:
			for(int i = 0; i<boat.getLenght(); i++) {
				if(i==0) {
					this.changeCharOnOwnVisualGrid(ligne, colonne, 'V');
				}
				else if(i==boat.getLenght()-1) {
					this.changeCharOnOwnVisualGrid(ligne, colonne, 'A');
				}
				else {
					this.changeCharOnOwnVisualGrid(ligne, colonne, '|');
				}
				ligne--;
			}
			break;
		case SOUTH:
			for(int i = 0; i<boat.getLenght(); i++) {
				if(i==0) {
					this.changeCharOnOwnVisualGrid(ligne, colonne, 'A');
				}
				else if(i==boat.getLenght()-1) {
					this.changeCharOnOwnVisualGrid(ligne, colonne, 'V');
				}
				else {
					this.changeCharOnOwnVisualGrid(ligne, colonne, '|');
				}
				ligne++;
			}
			break;
		case EAST:
			for(int i = 0; i<boat.getLenght(); i++) {
				if(i==0) {
					this.changeCharOnOwnVisualGrid(ligne, colonne, '<');
				}
				else if(i==boat.getLenght()-1) {
					this.changeCharOnOwnVisualGrid(ligne, colonne, '>');
				}
				else {
					this.changeCharOnOwnVisualGrid(ligne, colonne, '=');
				}
				colonne++;
			}
			break;
		case WEST:
			for(int i = 0; i<boat.getLenght(); i++) {
				if(i==0) {
					this.changeCharOnOwnVisualGrid(ligne, colonne, '>');
				}
				else if(i==boat.getLenght()-1) {
					this.changeCharOnOwnVisualGrid(ligne, colonne, '<');
				}
				else {
					this.changeCharOnOwnVisualGrid(ligne, colonne, '=');
				}
				colonne--;
			}
			break;
		}
	}
	
	/*
	 * Methode to String pour faire apparaitre au joueur le visuel de sa OwnGrid et son EnnemyGrid
	 */
	@Override
	public String toString() {
		String message = "Votre grille : \nX 0 1 2 3 4 5 6 7 8 9\n";
		for(int ligne = 0; ligne<10; ligne++) {
			message += ligne + " ";
			for(int colonne = 0; colonne<10; colonne++) {
				message += this.visualOwnGrid[ligne][colonne] + " ";
			}
			message+="\n";
		}
		message+="\nGrille de votre adversaire : \nX 0 1 2 3 4 5 6 7 8 9\n";
		for(int ligne = 0; ligne<10; ligne++) {
			message += ligne + " ";
			for(int colonne = 0; colonne<10; colonne++) {
				message += this.visualEnnemyGrid[ligne][colonne] + " ";
			}
			message+="\n";
		}
		return message;
	}
	/*
	 * Meme methode que le toString mais seulement pour la ownGrid
	 */
	public String OnlyOwnGrid() {
		String message = "Votre grille : \nX 0 1 2 3 4 5 6 7 8 9\n";
		for(int ligne = 0; ligne<10; ligne++) {
			message+=ligne + " ";
			for(int colonne = 0; colonne<10; colonne++) {
				message += this.visualOwnGrid[ligne][colonne] + " ";
			}
			message+="\n";
		}
		return message;
	}
}