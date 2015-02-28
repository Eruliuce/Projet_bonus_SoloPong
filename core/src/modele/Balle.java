package modele;

import outils.FichierConf;

public class Balle extends Item
{
	Deplacement depl;
	boolean durChoc;
	
	public Balle(Deplacement depl)
	{
		super(new Position(FichierConf.LARGEUR_ECRAN() / 2 - FichierConf.LARGEUR_BALLE() / 2, FichierConf.HAUTEUR_ECRAN() / 2 - FichierConf.LARGEUR_BALLE() / 2));
		haut = larg = FichierConf.LARGEUR_BALLE();
		this.depl = depl;
		depl.setPos(pos);
		durChoc = false;
	}

	public void moove()
	{
		depl.moove();
		if(pos.getX() <= 0)
		{
			pos.setX(0);
			depl.rebond(false);
		}
		else if(pos.getX() >= FichierConf.LARGEUR_ECRAN() - FichierConf.LARGEUR_BALLE())
		{
			pos.setX(FichierConf.LARGEUR_ECRAN() - FichierConf.LARGEUR_BALLE());
			depl.rebond(false);
		}
		else if(pos.getY() >= FichierConf.HAUTEUR_ECRAN() - FichierConf.LARGEUR_BALLE())
		{
			pos.setY(FichierConf.HAUTEUR_ECRAN() - FichierConf.LARGEUR_BALLE());
			depl.rebond(true);
		}
		else if(pos.getY() <= 0)
		{
			durChoc = true;
		}
	}

	public void rebond(Barre barre)
	{
		if(pos.getY() <= barre.getPos().getY() + barre.getHaut() && pos.getX() - larg >= barre.getPos().getX() && pos.getX() <= barre.getPos().getX() + barre.getLarg())
		{
			pos.setY(barre.getPos().getY() + barre.getHaut());
			depl.rebond(true);
		}
		else if(pos.getX() <= barre.getPos().getX())
		{
			pos.setX(barre.getPos().getX() - larg);
			depl.rebond(false);
		}
		else if(pos.getX() <= barre.getPos().getX() + barre.getLarg())
		{
			pos.setX(barre.getPos().getX() + barre.getLarg());
			depl.rebond(false);
		}
	}
	
	public boolean getDurChoc() {return durChoc;}
	public void initDurChoc() {durChoc = false;}

	@Override
	public void resetPos()
	{
		pos.set(FichierConf.LARGEUR_ECRAN() / 2 - FichierConf.LARGEUR_BALLE() / 2, FichierConf.HAUTEUR_ECRAN() / 2 - FichierConf.LARGEUR_BALLE() / 2);
		if(depl instanceof DeplacementDirection)
			((DeplacementDirection)depl).newDir();
	}
}
