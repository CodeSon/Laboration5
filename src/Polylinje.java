public class Polylinje {

	// Här skapar jag en lista av hörn
	private Punkt[] horn; // horn is the list and Punkt[] is the type

	// Polylinjens färg
	private String farg = "svart";

	// Polilinjens bredd
	private int bredd = 1;

	// Här skapas en konstruktur som är en ny polilinje med noll hörn
	public Polylinje() {
		this.horn = new Punkt[0];
	}

	/**
	 * En konstruktur som tar emot ett antal punkter och
	 * 
	 * @param horn
	 *            skapar en linje mellan punkterna
	 */
	public Polylinje(Punkt[] horn) {
		this.horn = new Punkt[horn.length];

		// Iterearer genom antalet punkter och kopierar dem
		for (int i = 0; i < horn.length; i++)

			this.horn[i] = new Punkt(horn[i]);
	}

	// Denna method skriver ut linjens farg
	public String toString() {
		return farg;
	}

	/**
	 * Här skapa man en vektor som innehåller en kopior av polylinjerns hörn och
	 * retunerar antalet hörn
	 * 
	 * @return
	 */
	public Punkt[] getHorn() {
		int antalElement = this.horn.length;// vi vill ha lika många element
		Punkt[] referensTillVektor = new Punkt[antalElement];

		for (int i = 0; i < antalElement; i++)

		{
			referensTillVektor[i] = new Punkt(this.horn[i]);// skapa en ny punkt
															// med kopia av den

		}

		return referensTillVektor;
	}

	// retunerear farg
	public String getFarg() {
		return farg;
	}

	// retunerar figurens bredd
	public int getBredd() {

		return bredd;
	}

	/**
	 * Här sätter man figurensfärg och dimensioner
	 * 
	 * @param farg
	 */
	public void setFarg(String farg) {
		this.farg = farg;
	}

	public void setBredd(int bredd) {
		this.bredd = bredd;
	}

	public double langd() {

		return this.horn.length;
	}

	/**
	 * Här kan man lägga en punkt till
	 * 
	 * @param horn
	 *            The point we want to add to the end of the list
	 */
	public void laggTill(Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1]; // Create a new list which
														// adds an extra spot
		int i = 0;

		for (i = 0; i < this.horn.length; i++) { // Iterate over the new list
			h[i] = this.horn[i]; // Transfer all the old points
		}
		h[i] = new Punkt(horn); // Add the new point to the end of the list

		this.horn = h; // Replace the old list
	}

	/**
	 * Här kopierar det hörnet som parameterreferensen refererar och lägger till
	 * hörnet på slutet av punktlistan kopiera till
	 * 
	 * @param horn
	 * @param hornNamn
	 */
	public void laggTillFramfor(Punkt horn, String hornNamn) {
		// this is an example of copying by reference: Punkt kopieraPunkt =
		// horn;

		Punkt[] newList = new Punkt[this.horn.length + 1]; // Create a new list
															// which is one
															// larger
		boolean hornFound = false;

		for (int i = 0; i < this.horn.length; i++) {

			if (this.horn[i].getNamn().equalsIgnoreCase(hornNamn)) // Om ett
																	// hörn that
																	// has same
																	// name as
																	// hornNamn
			{
				hornFound = true;
				newList[i] = new Punkt(horn); // this.name = new
												// String(p1.getNamn())
				newList[i + 1] = new Punkt(this.horn[i]);

			}

			else if (!hornFound) {

				newList[i] = new Punkt(this.horn[i]);

			} else {

				newList[i + 1] = new Punkt(this.horn[i]);

			}

		}
		this.horn = newList;
	}

	/**
	 * cannot be static because we are creating an instance of
	 * PolylinjeIterator,PolylinjeIteraor requires access to the member hörn and
	 * that is why PolylinjeIterator cannot be static Hörn doesnt exist until an
	 * instance of Polylinje is created
	 * 
	 * @return
	 */
	public PolylinjeIterator getIterator() {

		PolylinjeIterator minIterator = new PolylinjeIterator();

		return minIterator;
	}

	public void taBort(String hornNamn) {
		boolean foundIt= false;
		Punkt[] nyLista = new Punkt[this.horn.length-1];
		
		for(int i=0;i<horn.length;i++)
		{
			if(this.horn[i].getNamn().equalsIgnoreCase(hornNamn))
			{
				foundIt=true;
			}
			else if (!foundIt)
			{
				nyLista[i] = this.horn[i];
			} 
			else
			{
				nyLista[i-1]=this.horn[i];
			}
		}
		
		this.horn = nyLista;
	}

	public class PolylinjeIterator {
		private int aktuell = -1;

		public PolylinjeIterator() {
			if (Polylinje.this.horn.length > 0)
				aktuell = 0;
		}

		public boolean finnsHorn() {
			return aktuell != -1;
		}

		public Punkt horn() throws java.util.NoSuchElementException {
			if (!this.finnsHorn())
				throw new java.util.NoSuchElementException(
						"slut av iterationen");
			Punkt horn = Polylinje.this.horn[aktuell];
			return horn;
		}

		public void gaFram() {
			if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}
	}
}
