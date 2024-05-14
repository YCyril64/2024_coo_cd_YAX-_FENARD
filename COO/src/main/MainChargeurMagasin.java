package main;

import java.io.IOException;
import java.util.Scanner;

import donnees.*;
import XML.ChargeurMagasin;

/**
 * permet de charger un magasin de test
 */
public class MainChargeurMagasin {

	/**
	 * methode principale
	 * 
	 * @param args
	 *            inutilise
	 * @throws IOException
	 *             en cas de probleme de lecture entree/sortie
	 */
	public static void main(String args[]) throws IOException {
		
		String repertoire = "musicbrainzSimple/";
		ChargeurMagasin charge = new ChargeurMagasin(repertoire);
		Magasin resultat = charge.chargerMagasin();
		System.out.println(resultat.getCd(resultat.getNombreCds()-1));
		resultat.trier(new ComparateurPiste() {
		});
		System.out.println(resultat.getCd(resultat.getNombreCds()-1));




	}

}
