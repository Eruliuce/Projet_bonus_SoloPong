package outils;

import java.io.*;

public class FichierConf
{
	private static String CONF = "Config\\conf";
	private static float largeurEcran, hauteurEcran, largeurBalle, largeurBarre, hauteurBarre, distanceBarreEcran;
	
	private FichierConf(){}
	
	public static void InitFichierConf()
	{
		largeurEcran = getFloat("LARGEUR_ECRAN");
		hauteurEcran = getFloat("HAUTEUR_ECRAN");
		largeurBalle = getFloat("LARGEUR_BALLE");
		largeurBarre = getFloat("LARGEUR_BARRE");
		hauteurBarre = getFloat("HAUTEUR_BARRE");
		distanceBarreEcran = getFloat("DISTANCE_BARRE_ECRAN");
	}
	
	public static float LARGEUR_ECRAN() {return largeurEcran;}
	public static float HAUTEUR_ECRAN() {return hauteurEcran;}
	public static float LARGEUR_BALLE() {return largeurBalle;}
	public static float LARGEUR_BARRE() {return largeurBarre;}
	public static float HAUTEUR_BARRE() {return hauteurEcran;}
	public static float DISTANCE_BARRE_ECRAN() {return distanceBarreEcran;}
	
	
	private static float extractFloat(String line, String stat) throws NumberFormatException
	{
		return Float.parseFloat(line.substring(line.indexOf(":") + 1));
	}
	
	private static float getFloat(String stat)
	{
		float v = 0.f;
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(CONF));
			try
			{
				String line;
				boolean trouve = false;
				while ((line = buff.readLine()) != null && trouve)
				{
					System.out.println(line);
					if(line.contains(stat))
					{
						try
						{
							v = extractFloat(line, stat);
						}
						catch(NumberFormatException e)
						{
							System.out.println("Erreur : " + e.toString());
							System.exit(-1);
						}
						trouve = true;
					}
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException e)
		{
			System.out.println("Erreur : " + e.toString());
			System.exit(-1);
		}
		return v;
	}
}
