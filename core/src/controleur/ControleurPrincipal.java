package controleur;

import outils.FichierConf;
import vue.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ControleurPrincipal extends ApplicationAdapter
{
	InterfaceAffichage affichage;
	ControleurInputs cInputs;
	
	@Override
	public void create()
	{
		FichierConf.InitFichierConf();
		affichage = new Classic_BlackAndWhite();
		cInputs = new ControleurInputs();
	}

	@Override
	public void render()
	{
		Gdx.input.setInputProcessor(cInputs);
		
		//LETS GAME !
	}
}
