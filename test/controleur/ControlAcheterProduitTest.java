package controleur;


import personnages.Gaulois;
import villagegaulois.Village;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Gaulois bonemine;



	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		bonemine= new Gaulois("Bonemine",2);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs",10);
		
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		
		controlAcheterProduit = new ControlAcheterProduit( controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testAcheterProduit(){
		//assertNull(controlAcheterProduit.acheterProduit("herbe", 3));
		
		//Acheter plus que ce q'uil y a de possible
		int attendu_1 = 3;
		int resultat_1 = controlAcheterProduit.acheterProduit("Bonemine", 4);
		assertEquals(attendu_1, resultat_1);
		
		
		//Acheter exactement ce qu'il y a 
		int attendu_2 = 4;
		int resultat_2 = controlAcheterProduit.acheterProduit("Bonemine", 4);
		assertEquals(attendu_2, resultat_2);
		
		//Acheter moins que ce qu'il y a
		int attendu = 4;
	    int resultat = controlAcheterProduit.acheterProduit("Bonemine", 4);
		assertEquals(attendu, resultat);
		
		//faire les tests en fonction des quantites de produit
		
	}
//	
//	@Test
//	void testVerifierNom() {
//		
//	}
	
	@Test
	void testRechercherVendeursProduit() {
		//Le produit n'est pas present
		assertNull(controlAcheterProduit.rechercherVendeursProduit("herbe"));
		
		//Le produit est présent 
		String[] nomVendeurAttendu=new String[1];
		nomVendeurAttendu[0]="Bonemine";
		assertEquals(controlAcheterProduit.rechercherVendeursProduit("fleurs"),nomVendeurAttendu);
		
		
		
	}
	
	

	
	
}
