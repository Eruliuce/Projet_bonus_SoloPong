package controleur.desktop;

import outils.FichierConf;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import controleur.ControleurPrincipal;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		FichierConf.InitFichierConf();
		config.width = (int)FichierConf.LARGEUR_ECRAN();
		config.height = (int)FichierConf.HAUTEUR_ECRAN();
		new LwjglApplication(new ControleurPrincipal(), config);
	}
}
