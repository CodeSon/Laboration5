
/********************************************************************
 * A simple test program which utilises the constructors and methods in the
 * Polylinje class. The test made it possible to; 
 * 1) add a line with the length zero. 
 * 2) create two different co-ordinates (A & B). 
 * 3) insert a new co-ordinate (X) between co-ordinate A & co-ordinate B.
 * 
 * @author David Nartey
 *
 ***************************************************/
public class PolylinjeTest {

	public static void main(String[] args) {
		Polylinje nollLangd = new Polylinje();// creating new line with length
												// zero

		System.out.println("Längd av nollLängd: " + nollLangd.langd());
		System.out.println("------------------------ \n");

		Punkt[] horns = { new Punkt("A", 2, 1), new Punkt("B", 3, 2),
				new Punkt("C", 1, 2), new Punkt("D", 5, 7) };// creating a list
																// of points.

		Polylinje newLine = new Polylinje(horns);// creating a new line that
													// contains the two points
													// above
		// printing the points in the list
		for (int i = 0; i < newLine.langd(); i++) {
			System.out.println(newLine.getHorn()[i]);

		}

		System.out.println();
		System.out.println("Här har vi lagt ett nytt punkt X framför punkt A");
		System.out.println("------------------------------------------------ \n");

		Punkt extraPunkt = new Punkt("X", 6, 9);

		newLine.laggTillFramfor(extraPunkt, "B");

		for (int i = 0; i < newLine.langd(); i++) {
			System.out.println(newLine.getHorn()[i]);
		}

		newLine.taBort("X");

		Polylinje.PolylinjeIterator iterator = newLine.getIterator();

		System.out.println();
		System.out.println("Här har vi tabort punkten X med hjälp av en iterator");
		System.out.println("----------------------------------------------------");
		while (iterator.finnsHorn()) // whiles there are edges left to look at
		{
			System.out.println(iterator.horn());// will get current edge and
												// print it out
			iterator.gaFram();
		}
	}

}
