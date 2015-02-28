package vue;

import java.util.Collection;

import outils.FichierConf;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import modele.*;

public class Classic_BlackAndWhite implements InterfaceAffichage
{
	ShapeRenderer shapeRenderer;
	
	public Classic_BlackAndWhite()
	{
		shapeRenderer = new ShapeRenderer();
	}
	
	@Override
	public void render(Collection<Item> items)
	{
		Gdx.graphics.getGL20().glClearColor( 1, 1, 1, 1 );
		Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.BLACK);
		for(Item i : items)
		{
			if(i instanceof Balle)
				afficherBalle((Balle)i);
			else if(i instanceof Barre)
				afficherBarre((Barre)i);
		}
		shapeRenderer.end();
	}

	@Override
	public void afficherBalle(Balle b)
	{
		shapeRenderer.rect(b.getPos().getX(), b.getPos().getY(), b.getLarg(), b.getHaut());
	}

	@Override
	public void afficherBarre(Barre b)
	{
		shapeRenderer.rect(b.getPos().getX(), b.getPos().getY(), b.getLarg(), b.getHaut());
	}

}
