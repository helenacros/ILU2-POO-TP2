package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			StringBuilder question_force = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			question_force.append("Quelle est votre force ?\n");
			int choixUtilisateur = -1;
			int choixForce=-1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois "+nomVisiteur);
					choixForce = Clavier.entrerEntier(question_force.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,choixForce);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide "+nomVisiteur);
		int choixForce=-1;
		StringBuilder question_force = new StringBuilder();
		question_force.append("Quelle est votre force ?\n");
		choixForce = Clavier.entrerEntier(question_force.toString());
		int effetPotionMax=-1;
		int effetPotionMin=-2;
		StringBuilder potion_min = new StringBuilder();
		potion_min.append("Quelle est est là force de la potion la plus faible que produisez ?\n");
		StringBuilder potion_max = new StringBuilder();
		potion_max.append("Quelle est là force de la potion la plus forte que vous produisez ?\n");
		while(effetPotionMax<effetPotionMin) {
			effetPotionMin = Clavier.entrerEntier(potion_min.toString());
			effetPotionMax = Clavier.entrerEntier(potion_max.toString());
			if(effetPotionMax<effetPotionMin) {
				System.out.println("Attention druide, vous vous êtes trompé entre le min et le max \n");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur,choixForce,effetPotionMin,effetPotionMax);
		
		
			
		
	}
}
