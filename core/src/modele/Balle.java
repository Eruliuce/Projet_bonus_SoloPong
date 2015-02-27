package modele;

import outils.FichierConf;

public class Balle extends Item
{

	public Balle()
	{
		super(new Position(FichierConf.LARGEUR_ECRAN() / 2, FichierConf.HAUTEUR_ECRAN() / 2));
		haut = larg = FichierConf.LARGEUR_BALLE();
	}
	
}
