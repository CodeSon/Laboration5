/********************************************************************
 *  A simple test program which utilises the constructors and methods
 *  in the Polylinje class. Tthe test made it possible to;
 *  1) a line with the leght zero. 
 *  2) create two different co-ordinates (A & B).
 *  3) insert a new co-ordinate (X) between (A & B).
 *  
 * @author David Nartey
 *
 ***************************************************/
public class PolylinjeTest {

	public static void main(String[] args) {
		Polylinje nollLangd= new Polylinje();//creating new line with length zero
		
		System.out.println("Längd av nollLängd: " + nollLangd.langd() + "\n");
		
		Punkt[] horns = {new Punkt("A", 2, 1), new Punkt("B", 3, 2)};//creating a list of points.
		
		Polylinje l = new Polylinje(horns);//creating a new line that contains the two points above
		//printing the points in the list
		for (int i = 0; i < l.langd(); i++) {
			System.out.println(l.getHorn()[i]);
		}
		
		System.out.println();
		System.out.println("Här har vi lagt ett nytt punkt framför");
		
		Punkt extraPunkt = new Punkt("X", 6, 9);
	
		l.laggTillFramfor(extraPunkt, "B");
		
		for (int i = 0; i < l.langd(); i++) {
			System.out.println(l.getHorn()[i]);
		}
	}

}
