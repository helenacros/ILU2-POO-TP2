package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean isVendeur= controlLibererEtal.isVendeur(nomVendeur);
		
		if(!isVendeur) {
			System.out.println("Mais vous n'êtes aps inscrit sur notre marché aujourd'hui \n");
		}
		else {
			String[] donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe= Boolean.valueOf(donneesEtal[0]);
			if(etalOccupe) {
				System.out.println("Vous avez vendu "+donneesEtal[4]+" sur "+donneesEtal[3]+" "+donneesEtal[2]+". \n");
				System.out.println("En revoir "+nomVendeur+", passez une bonne journée \n");
			}
		}
	}

}
