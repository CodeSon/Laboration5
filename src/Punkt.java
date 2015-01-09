/**colour coding
 * //String object and objects are black in colour 
 * /primitive and thats why its maroon
 * @author David Nartey
 *
 */
public class Punkt {
	private String name;
	private int x;
	private int y;
	
	//Creating a point
	public Punkt(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y =y;
	}
/**
 * A Constructor created and copy by value implemented
 * @param p1
 */
	public Punkt(Punkt p1) {// creating identical points
		this.name = new String(p1.getNamn());// A new string that gets all the characters from another(copy by value)
		this.name = p1.getNamn();//these two point to the same string so its copy by reference
		this.x = p1.getX();
		this.y = p1.getY();
	}

	/**
	 * Returning the name of the points
	 * @return
	 */
	public String getNamn() {
		return this.name;
	}

	public int getX() {
		
		return this.x;
	}

	public int getY() {

		return this.y;
	}

	public double avstand(Punkt p2) {
		
		double distance;
		distance = Math.sqrt((Math.pow(p2.getX() - this.getX(), 2)) + (Math.pow(p2.getY() - this.getY(),2)));
		
		return distance;
	}

	public void setX(int i) {// replacing the X cordinate
		this.x = i;
		
		
	}

	public void setY(int i) {
		this.y=i;
		
	}
	
	/**
	 * Compare x coordinates of this instance and Punkt p
	 * @param p a different Punkt
	 * @return true if coordinates are the same, false if not
	 */
	public boolean equals(Punkt p){
		if (this.getX() == p.getX() && this.getY() == p.getY()) {
			return true;
		} else return false;
	}
	
	public String toString() {
		return this.name + "(" + this.x + "," + this.y + ")";
	}

}
