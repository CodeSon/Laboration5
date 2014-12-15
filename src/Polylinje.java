
public class Polylinje {
	
	//H�r s�tter jag antalet h�rn 
	private Punkt[] horn;
	
	//Polylinjens f�rg
	private String farg = "svart";
	
	//Polilinjens bredd
	 private int bredd = 1;
	 
	 //H�r skapas en konstruktur som �r en ny polilinje med noll h�rn
	 public Polylinje ()
	 {
	 this.horn = new Punkt[0];
	 }
	
	 /**
	  * En konstruktur som tar emot ett antal punkter och 
	  * @param horn skapar en linje mellan punkterna
	  */
	 public Polylinje (Punkt[] horn)
	 {
	 this.horn = new Punkt[horn.length];
	
	 //Iterearer genom antalet punkter och kopierar dem
	 for (int i = 0; i < horn.length; i++)
	
		 this.horn[i] = new Punkt (horn[i]);
	 }
	 
	 // Denna method skriver ut linjens farg
	 public String toString () {
		return farg;}
	 
	 
	 // retunerar antalet h�rn
	 public Punkt[] getHorn () {
		return horn;}
	 
	 //retunerear farg
	 public String getFarg () {
		return farg;}
	 
	 //retunerar figurens bredd
	 public int getBredd () {
		
		 return bredd;}
	 
	 /**
	  * H�r s�tter man figurensf�rg
	  * och dimensioner
	  * @param farg
	  */
	 public void setFarg (String farg) {
		 
	 
	 }
	 
	
	 public void setBredd (int bredd) {
		 
	 }
	
	 public double langd () {
		
		 return bredd;}
	 
	
	 /**
	  * H�r kan man l�gga en punkt till 
	  * @param horn
	  */
	 public void laggTill (Punkt horn)
	 {
	 
	
	Punkt[] h = new Punkt[this.horn.length + 1];
	 int i = 0;
	 for (i = 0; i < this.horn.length; i++)
	 h[i] = this.horn[i];
	 h[i] = new Punkt (horn);
	 this.horn = h;
	 }
	 public void laggTillFramfor (Punkt horn, String hornNamn) {}
	 public void taBort (String hornNamn) {}
	}


