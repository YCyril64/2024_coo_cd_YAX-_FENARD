package donnees;

import java.util.ArrayList;
import java.util.Collections;

/**
 * La classe Magasin represente un magasin qui vend des CDs.</p>
 * 
 * cette classe est caracterisee par un ensemble de CDs correspondant aux CDS
 * vendus dans ce magasin.
 * 
 */
public class Magasin {

	/**
	 * la liste des CDs disponibles en magasin
	 */
	private ArrayList<CD> listeCds;

	/**
	 * construit un magasin par defaut qui ne contient pas de CD
	 */
	public Magasin() {
		listeCds = new ArrayList<CD>();
	}

	/**
	 * ajoute un cd au magasin
	 * 
	 * @param cdAAjouter
	 *            le cd a ajouter
	 */
	public void ajouteCd(CD cdAAjouter) {
		listeCds.add(cdAAjouter);
	}

	public void trieCD(){
		int mini;
		for(int i=0; i < listeCds.size(); i++) {
			mini = i;
			for (int j = i; j < listeCds.size()  ; j++) {
				mini = listeCds.get(mini).compareToTitre(listeCds.get(j)) < 0 ? mini : j;

			}
			Collections.swap(listeCds, mini, i);
		}
	}

	public void trieArtiste(){
		int mini;
		for(int i=0; i < listeCds.size(); i++) {
			mini = i;
			for (int j = i; j < listeCds.size()  ; j++) {
				mini = listeCds.get(mini).compareToArtiste(listeCds.get(j)) < 0 ? mini : j;
			}
			Collections.swap(listeCds, mini, i);
		}
	}

	@Override
	/**
	 * affiche le contenu du magasin
	 */
	public String toString() {
		String chaineResultat = "";
		//parcours des Cds
		for (int i = 0; i < listeCds.size(); i++) {
			chaineResultat += listeCds.get(i);
		}
		chaineResultat += "nb Cds: " + listeCds.size();
		return (chaineResultat);

	}

	/**
	 * @return le nombre de Cds du magasin
	 */
	public int getNombreCds() {
		return listeCds.size();
	}
	
	/**
	 * permet d'acceder � un CD
	 * 
	 * @return le cd a l'indice i ou null si indice est non valide
	 */
	public CD getCd(int i)
	{
		CD res=null;
		if ((i>=0)&&(i<this.listeCds.size()))
			res=this.listeCds.get(i);
		return(res);
	}

	public void trier(ComparateurCd cCD){
		int mini;
		for(int i=0; i < listeCds.size(); i++) {
			mini = i;
			for (int j = i; j < listeCds.size()  ; j++) {
				mini = cCD.etreAvant(listeCds.get(mini),listeCds.get(j)) ? mini : j;
			}
			Collections.swap(listeCds, mini, i);
		}
	}

	public ArrayList<CD> getListeCds() {
		return listeCds;
	}



}
