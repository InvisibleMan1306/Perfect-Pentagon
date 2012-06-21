package Cage;

public class PerfectPentagon 
{

	final static int mag = 10;
//	final static int angle = 72;
	final static int sides = 5;
	
	public static void main(String args[])
	{		
		int angle = 360/sides;
		LineSeg[] big_shape = new LineSeg[sides];
		LineSeg[] star = new LineSeg[sides];
		LineSeg[] small_shape = new LineSeg[sides];
		
		big_shape[0] = new LineSeg(0,0,mag,0);
//		System.out.println("Line 1");
//		big_shape[0].printPoints();
		
		for (int i=1; i<sides; i++){//perfect big_shapeagon
			big_shape[i] = new LineSeg(big_shape[i-1].pt2, mag, (i*angle));
//			System.out.println("\nLine " + (i+1) + "; Mag = " + big_shape[i].getLength());
//			big_shape[i].printPoints();
		}
		
		for (int i=0; i<sides; i++){//perfect big_shapeagram star
			star[i] = new LineSeg(big_shape[i].pt1, big_shape[(i+2)%sides].pt1);
//			System.out.println("\nLine " + (i+1) + "; Mag = " + star[i].getLength());
//			star[i].printPoints();
		}
		
		for (int i=0; i<sides; i++){
//			System.out.println(getLineIntersect(star[i],star[(i+1)%sides]).toString());
			XYPoint pt1 = getLineIntersect(star[i],star[(i+1)%sides]);
			XYPoint pt2 = getLineIntersect(star[(i+1)%sides],star[(i+2)%sides]);
			small_shape[i] = new LineSeg(pt1,pt2);
			System.out.println(small_shape[i].getLength());
		}
	}
	
	public static XYPoint getLineIntersect(LineSeg seg1, LineSeg seg2)
	{
		seg1.setStandard(); seg2.setStandard();
		double x = (seg2.B - seg1.B)/(seg1.M-seg2.M);
		double y = seg1.M*x + seg1.B;
		return new XYPoint(x,y);
	}
	
	public static double roundToNearest(double d, int pow)
	{
		double div = Math.pow(10, pow);
		return Math.round(d*div)/div;
	}
}
