package controleur;

import java.util.*;

import outils.FichierConf;
import vue.*;
import modele.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class ControleurPrincipal extends ApplicationAdapter
{
	InterfaceAffichage affichage;
	ControleurInputs cInputs;
	Collection<Item> items;
	Barre barre;
	boolean finDuGame = false;
	boolean debutDeLaFin = true;
	long tempsDeb;
	long duree = 0;
	
	@Override
	public void create()
	{
		affichage = new Classic_BlackAndWhite();
		items = new ArrayList<Item>();
		Random rand = new Random();
		items.add(new Balle(new DeplacementDirection(rand.nextFloat() * 2 * (float)Math.PI)));
		barre = new Barre();
		items.add(barre);
		cInputs = new ControleurInputs();
		Gdx.input.setInputProcessor(cInputs);
		tempsDeb = System.nanoTime();
	}

	@Override
	public void render()
	{	
		if(finDuGame)
		{
			if(debutDeLaFin)
			{
				duree = System.nanoTime() - tempsDeb;
				debutDeLaFin = false;
			}
			affichage.afficherRes(duree);
			if(cInputs.getEnter())
			{
				barre.resetPos();
				tempsDeb = System.nanoTime();
				finDuGame = false;
				debutDeLaFin = true;
				for(Item i : items)
				{
					if(i instanceof Balle)
					{
						((Balle)i).resetPos();
						((Balle)i).initDurChoc();
					}
				}
				Vitesse.vitesseInit();
			}
		}
		else
		{
			affichage.render(items);
			if(cInputs.getLeft() && barre.getPos().getX() > 0)
				barre.moove(-1);
			else if(cInputs.getRight() && barre.getPos().getX() < FichierConf.LARGEUR_ECRAN() - FichierConf.LARGEUR_BARRE())
				barre.moove(1);
			for(Item i : items)
			{
				if(i instanceof Balle)
				{
					((Balle)i).moove();
					if(((Balle)i).hitAABB(barre))
						((Balle)i).rebond(barre);
					if(((Balle)i).getDurChoc())
						finDuGame = true;
				}
			}
		}
	}
}
