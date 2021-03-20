class Point {
	  public int x, y;
	  public boolean equals(Object other) {
	    if (other == this) return true;
	    if (other == null) return false;
	    if (getClass() != other.getClass()) return false;
	    Point point = (Point)other;
	    return (x == point.x && y == point.y);
	  }
	}

public class MainClass {
	  public static void main(String[] a) {
	    
	    Point A = new Point();
	    A.x = 3;
	    A.y = 5;
	    
	    Point B = new Point();
	    B.x = 3;
	    B.y = 5;
	    
	    System.out.println(A.equals(B));
	    
	  }

	}