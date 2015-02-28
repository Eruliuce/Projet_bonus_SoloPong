package modele;

public abstract class Item
{
	protected Position pos;
	protected float larg, haut;
	
	public Item(Position pos)
	{
		this.pos = pos;
		this.larg = larg;
		this.haut = haut;
	}
	
	public Position getPos() {return pos;}
	public float getLarg() {return larg;}
	public float getHaut() {return haut;}
	
	public boolean hitAABB(Item i)
	{
		float x1 = pos.getX(), x2 = i.getPos().getX(), y1 = pos.getY(), y2 = i.getPos().getY(), l1 = larg, l2 = i.getLarg(), h1 = haut, h2 = i.getHaut();
		if((x2 >= x1 + l1) || (x2 + l2 <= x1) || (y2 >= y1 + h1) || (y2 + h2 <= y1))
	          return false; 
	   else
	          return true; 
	}
	
	public abstract void resetPos();
}
