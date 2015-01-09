import java.io.ObjectInputStream.GetField;
import java.util.Random;

public class Valjpolylinje {
	
public static final Random rand = new Random();
	public static final int ANTAL_POLYLINJER = 10;

	public static void main(String[] args) {
		System.out.println("F�rgen,listan och h�rn skrivs ut");
		System.out.println("--------------------------------");
		System.out.println();
		// skapa ett antal slumpm�ssiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje();

		// visa linjer
		visa(polylinjer);

		// best�m den kortaste av de polylinjer som �r gula
		Polylinje kortasteGula = finnKortasteGula(polylinjer);

		// visa den valda polylinjen
		visa(kortasteGula);
	}

	private static void visa(Polylinje kortasteGula) {
		if (kortasteGula == null) {
			System.out.println("det finns ingen gullinje");
		} else {
			Polylinje minlinje = kortasteGula;
			System.out.println(minlinje.getFarg() + ":"+" "
					+ visaPunkter(minlinje.getHorn()));// f�rgen och listan h�rn
			// i linjen skrivs ut
			System.out.println();
		}
	}

	private static Polylinje finnKortasteGula(Polylinje[] polylinjer) {
		Polylinje kortasteGula = null;// om inga gula linje finns f�rblir den
										// noll
		
		for (Polylinje nuvarandeLinje : polylinjer)// Fr�n denna listan plocka
													// ut en linje efter
													// varandra
		{
			if (nuvarandeLinje.getFarg().equalsIgnoreCase("Gul")
					&& kortasteGula == null) {
				kortasteGula = nuvarandeLinje;
			} else if (nuvarandeLinje.getFarg().equalsIgnoreCase("Gul")) {
				if (nuvarandeLinje.getHorn().length < kortasteGula.getHorn().length) {
					
					kortasteGula = nuvarandeLinje;
				}
			}

		}

		return kortasteGula;
	}

	// slumpPunkt returnerar en punkt med ett slumpm�ssigt namn, som �r en stor
	// bokstav i
	// det engelska alfabetet, och slumpm�ssiga koordinater.
	public static Punkt slumpPunkt() {
		String n = "" + (char) (65 + rand.nextInt(26));
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);
		return new Punkt(n, x, y);

	}

	/**
	 * Loopar igenom alla linjer och skriv ut dem
	 * 
	 * @param linjer
	 */
	public static void visa(Polylinje[] linjer) {
		for (int i = 0; i < linjer.length; i++) {
			visa(linjer[i]);
		}
	}

	/**
	 * visaPunkter skapar en st�ng av punktlistan
	 * 
	 * @param horn
	 *            �r en lista av punkterna skappar linjerna
	 * @return
	 */

	private static String visaPunkter(Punkt[] horn) {
		String punktlista = "";

		for (int i = 0; i < horn.length; i++) {

			Punkt minPunkt = horn[i];
			punktlista = punktlista + minPunkt.toString() + ",";// man l�gger
																// till punkter
																// i en str�ng

		}

		return punktlista;
	}

	// slumpPolylinje returnerar en slumpm�ssig polylinje, vars f�rg �r antingen
	// bl�, eller r�d
	// eller gul. Namn p� polylinjens h�rn �r stora bokst�ver i det engelska
	// alfabetet. Tv� h�rn
	// kan inte ha samma namn.
	public static Polylinje slumpPolylinje() {
		// skapa en tom polylinje, och l�gg till h�rn till den
		Polylinje polylinje = new Polylinje();
		int antalHorn = 2 + rand.nextInt(7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		// ett och samma namn kan inte f�rekomma flera g�nger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn < antalHorn) {
			valdPunkt = slumpPunkt();
			valtChar = valdPunkt.getNamn().charAt(0);
			int code = (int) valtChar;// converting the alphabet that comes out
			// into its numeric value
			// h�r kontrolerar om namnet ej finns.Annars f�rs�k igen
			if (!valdaNamn[code - 65]) {
				polylinje.laggTill(slumpPunkt());
				valdaNamn[code - 65] = true;// noterar att redan finns
				antalValdaHorn++;
			}
		}
		// H�r s�tter man farg till polylinjen slumpm�ssigt
		polylinje.setFarg(slumpFarg());

		return polylinje;
	}

	// h�r skapa man en slumpFarg(r�d,gron eller bl�)
	public static String slumpFarg() {

		String[] slumpFarg = { "R�d", "Gr�n", "Gul" };

		int slump = rand.nextInt(3);
		String minFarg = slumpFarg[slump];

		return minFarg;

	}
}
