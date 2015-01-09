import java.io.ObjectInputStream.GetField;
import java.util.Random;

public class Valjpolylinje {
	
public static final Random rand = new Random();
	public static final int ANTAL_POLYLINJER = 10;

	public static void main(String[] args) {
		System.out.println("Färgen,listan och hörn skrivs ut");
		System.out.println("--------------------------------");
		System.out.println();
		// skapa ett antal slumpmässiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje();

		// visa linjer
		visa(polylinjer);

		// bestäm den kortaste av de polylinjer som är gula
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
					+ visaPunkter(minlinje.getHorn()));// färgen och listan hörn
			// i linjen skrivs ut
			System.out.println();
		}
	}

	private static Polylinje finnKortasteGula(Polylinje[] polylinjer) {
		Polylinje kortasteGula = null;// om inga gula linje finns förblir den
										// noll
		
		for (Polylinje nuvarandeLinje : polylinjer)// Från denna listan plocka
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

	// slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor
	// bokstav i
	// det engelska alfabetet, och slumpmässiga koordinater.
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
	 * visaPunkter skapar en stäng av punktlistan
	 * 
	 * @param horn
	 *            är en lista av punkterna skappar linjerna
	 * @return
	 */

	private static String visaPunkter(Punkt[] horn) {
		String punktlista = "";

		for (int i = 0; i < horn.length; i++) {

			Punkt minPunkt = horn[i];
			punktlista = punktlista + minPunkt.toString() + ",";// man lägger
																// till punkter
																// i en sträng

		}

		return punktlista;
	}

	// slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen
	// blå, eller röd
	// eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska
	// alfabetet. Två hörn
	// kan inte ha samma namn.
	public static Polylinje slumpPolylinje() {
		// skapa en tom polylinje, och lägg till hörn till den
		Polylinje polylinje = new Polylinje();
		int antalHorn = 2 + rand.nextInt(7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		// ett och samma namn kan inte förekomma flera gånger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn < antalHorn) {
			valdPunkt = slumpPunkt();
			valtChar = valdPunkt.getNamn().charAt(0);
			int code = (int) valtChar;// converting the alphabet that comes out
			// into its numeric value
			// här kontrolerar om namnet ej finns.Annars försök igen
			if (!valdaNamn[code - 65]) {
				polylinje.laggTill(slumpPunkt());
				valdaNamn[code - 65] = true;// noterar att redan finns
				antalValdaHorn++;
			}
		}
		// Här sätter man farg till polylinjen slumpmässigt
		polylinje.setFarg(slumpFarg());

		return polylinje;
	}

	// här skapa man en slumpFarg(röd,gron eller blå)
	public static String slumpFarg() {

		String[] slumpFarg = { "Röd", "Grön", "Gul" };

		int slump = rand.nextInt(3);
		String minFarg = slumpFarg[slump];

		return minFarg;

	}
}
