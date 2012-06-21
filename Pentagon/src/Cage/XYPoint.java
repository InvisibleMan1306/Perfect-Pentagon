package Cage;

public class XYPoint 
{
	double x, y;
	
	public XYPoint(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public XYPoint(XYPoint pt)
	{
		x = pt.x;
		y = pt.y;
	}
	
	public boolean isOrgin()
	{
		if (x==0&&y==0)
			return true;
		else
			return false;
	}
	
	public double getLength(XYPoint pt){
		return Math.hypot(x-pt.x,y-pt.y);
	}
	
	public double getLength(double x1, double y1){
		return Math.hypot(x-x1,y-y1);
	}
	
	public double getM(XYPoint pt){
		return (y-pt.y)/(x-pt.x);
	}
	
	public double getM(double x1, double y1){
		return (y-y1)/(x-x1);
	}
	
	public double getAngle(XYPoint pt){
		return Math.toDegrees(Math.atan2(y-pt.y, x-pt.x));
	}
	
	public double getAngle(double x1, double y1){
		return Math.toDegrees(Math.atan2(y-y1, x-x1));
	}
		
	public double getVecMag(){
		return Math.hypot(x,y);
	}
	
	public double getVectorAngle(){
		return Math.toDegrees(Math.atan2(y, x));
	}
	
	public String toString(){
		return x + ", " + y;
	}
}
