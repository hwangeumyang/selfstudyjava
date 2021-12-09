package chap12.sec02;

enum  Direction { EAST, WEST, SOUTH, NORTH }

public class EnumEx1 {	
	public static void main(String [] args) {
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1 == d2 ? " + (d1 == d2));
		System.out.println("d1 == d3 ? " + (d1 == d3));
		System.out.println("d1.equals(d2) ? " + d1.equals(d2));
		
//		System.out.println("d2 > d3 ? " + (d2 > d3)); Error
		System.out.println("d1.compareTo(d2) " + d1.compareTo(d2));
		System.out.println("d1.compareTo(d3) " + d1.compareTo(d3));
		
		switch(d1) {
		case EAST:
			System.out.println("east"); break;
		case WEST:
			System.out.println("west"); break;
		case SOUTH:
			System.out.println("SOUTH"); break;
		case NORTH:
			System.out.println("north"); break;
		}

		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr)
			System.out.printf("%s = %d%n" , d.name(), d.ordinal());
		
		
	}

}
