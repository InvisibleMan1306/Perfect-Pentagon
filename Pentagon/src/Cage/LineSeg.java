package Cage;

public class LineSeg 
{
	XYPoint pt1, pt2;
	double M, B;
	
	
	public LineSeg(XYPoint pt1, XYPoint pt2)
	{
		this.pt1 = new XYPoint(pt1);
		this.pt2 = new XYPoint(pt2);
	}
	
	public LineSeg(XYPoint pt, double magnitude, double theta)
	{
		pt1 = new XYPoint(pt);
		double x = magnitude*Math.cos(Math.toRadians(theta)) + pt.x;
		double y = magnitude*Math.sin(Math.toRadians(theta)) + pt.y;
		pt2 = new XYPoint(x,y);
	}
	
	public LineSeg (double x1, double y1, double x2, double y2)
	{
		pt1 = new XYPoint(x1, y1);
		pt2 = new XYPoint(x2, y2);
	}
	
	public double getLength(){
		return pt1.getLength(pt2);
	}
	
	public double getAngle(){
		boolean isClosest = pt1.getVecMag()>pt2.getVecMag();
		return (isClosest ? pt1 : pt2).getAngle(isClosest ? pt2 : pt1);
	}
	
	public boolean isInRange(double target, double a1, double a2)
	{
		//used for magnitude calc of lines with 90 degree angle
		if (a1==a2&&target<a1)
			return true;
		
		double max = a1>a2 ? a1:a2;
		double min = a1<a2 ? a1:a2;
		
		if(target<=max&&target>=min)
			return true;
		else
			return false;
	}

	public boolean isOnLineSegment(XYPoint pt)
	{
		//creates a line segment with 
		double mag1 = pt1.getVecMag();
		double mag2 = pt2.getVecMag();
		LineSeg temp = new LineSeg((mag1>mag2 ? pt1: pt2), pt);
		System.out.println(temp.getAngle() + " " + getAngle());
		if (temp.getAngle()==getAngle()){
			System.out.println("Angle");
			if (isInRange(pt.getVecMag(),mag1, mag2)){
				return true;
			}
		}		
		
		return false;
	}
	
	public void setStandard()
	{
		M = (pt1.y-pt2.y)/(pt1.x-pt2.x);
		B = pt1.y - (pt1.x*M);
//		System.out.println("M: " + M + "B: " + B);
	}
	
	
	
	public void printPoints(){
		System.out.println("Pt1: "+pt1.toString()+"\nPt2: "+pt2.toString());
	}
	
}
