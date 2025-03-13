package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		Boolean nomVendeurConnu=controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commencer ici\n");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal\n");
			Boolean etalDisponible=controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Désoléé "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé\n");
			}
			else {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un étal pour vous !\n");
				StringBuilder question = new StringBuilder();
				String produit;
				question.append("Quel produits souhaitez-vous vendre ?\n");
				produit = Clavier.entrerChaine(question.toString());
				
				StringBuilder question2 = new StringBuilder();
				int nb_prod;
				question.append("Quel nombre de produits souhaitez-vous vendre ?\n");
				nb_prod = Clavier.entrerEntier(question2.toString());
				
				int num_etal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nb_prod);
				if(num_etal!=1) {
					System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+num_etal);
				}
				
			}
		}
		
		
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
