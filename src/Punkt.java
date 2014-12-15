
public class Punkt {
	private String name;
	private int x;
	private int y;
	public Punkt(String string, int i, int j) {
		this.name = string;
		this.x = i;
		this.y =j;
	}

	public Punkt(Punkt p1) {// creating identical points
		this.name = p1.getNamn();
		this.x = p1.getX();
		this.y = p1.getX();
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
