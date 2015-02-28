package modele;

public class Position
{
	private float x;
	private float y;
	
	public Position(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void set(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public void deplX(float x)
	{
		this.x += x;
	}
	
	public void deplY(float Y)
	{
		this.x += Y;
	}
	
	public float getX() {return x;}
	public float getY() {return y;}
}
