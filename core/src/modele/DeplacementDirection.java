package modele;

import java.util.Random;

public class DeplacementDirection implements Deplacement
{
	private float angle;
	private Position pos;
	
	public DeplacementDirection(float angle)
	{
		this.angle = angle;
	}

	@Override
	public void moove()
	{
		pos.set(pos.getX() + Vitesse.getVitesse() * (float)Math.cos(angle), pos.getY() + Vitesse.getVitesse() * (float)Math.sin(angle));
	}

	@Override
	public void setPos(Position pos)
	{
		this.pos = pos;
	}
	
	public void rebond(boolean haut)
	{
		if(haut)
			angle = 2 * (float)Math.PI - angle;
		else
			angle = (float)Math.PI - angle;
		Vitesse.vitessePlus();
	}
	
	public void newDir()
	{
		Random rand = new Random();
		angle = rand.nextFloat() * 2 * (float)Math.PI;
	}
}
