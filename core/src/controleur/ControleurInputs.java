package controleur;


import modele.Barre;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

/* Single responsability : gérer les inputs */

public class ControleurInputs implements InputProcessor
{
	private boolean pushLeft = false, pushRight = false;
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode)
		{
			case Input.Keys.RIGHT :
				pushRight = true;
				pushLeft = false;
			break;
			case Input.Keys.LEFT :
				pushLeft = true;
				pushRight = false;
			default:
			break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		switch (keycode)
		{
			case Input.Keys.RIGHT :
				pushRight = false;
			break;
			case Input.Keys.LEFT :
				pushLeft = false;
			default:
			break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean getLeft()
	{
		return pushLeft;
	}
	
	public boolean getRight()
	{
		return pushRight;
	}
}
