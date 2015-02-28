package vue;

import java.util.Collection;

import modele.*;

public interface InterfaceAffichage
{
	public void render(Collection<Item> items);
	public void afficherBalle(Balle b);
	public void afficherBarre(Barre b);
}
