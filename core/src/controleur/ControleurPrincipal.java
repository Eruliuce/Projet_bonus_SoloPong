package controleur;

import java.util.*;

import outils.FichierConf;
import vue.*;
import modele.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class ControleurPrincipal extends ApplicationAdapter
{
	InterfaceAffichage affichage;
	ControleurInputs cInputs;
	Collection<Item> items;
	Barre barre;
	boolean finDuGame = false;
	
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
	}

	@Override
	public void render()
	{
		affichage.render(items);
		
		if(finDuGame)
		{
			finDuGame = false;
			barre.resetPos();
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
