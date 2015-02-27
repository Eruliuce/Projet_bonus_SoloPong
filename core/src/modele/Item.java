package modele;

public abstract class Item
{
	protected Position pos;
	protected float larg, haut;
	
	public Item(Position pos)
	{
		this.pos = pos;
	}
	
	public Position getPos() {return pos;}
	public float getLarg() {return larg;}
	public float getHaut() {return haut;}
	
	public boolean hit(Item i)
	{
		float x1 = pos.getX(), x2 = i.getPos().getX(), y1 = pos.getY(), y2 = i.getPos().getY(), h = i.getHaut();
		return x1 < x2 ? x1 + larg > x2 ? y1 < y2 ? y1 + haut > y2 ? true : false : y1 < y2 + h ? true : false : false : i.hit(this);
	}
}
