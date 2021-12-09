package chap12.sec02;

public class EnumEx3 {
	enum Transportation {
		BUS(100) { int fare(int distance) { return distance * BASIC_FARE; } },
		TRAIN(150) { int fare(int distance) { return distance * BASIC_FARE; } },
		SHIP(100) { int fare(int distance) { return distance * BASIC_FARE; } },
		AIRPLANE(300) { int fare(int distance) { return distance * BASIC_FARE; } };
		
		protected final int BASIC_FARE; //각 상수에서 접근하려면 protected로 해야한다.
		
		Transportation(int basic_fare) {
			BASIC_FARE = basic_fare;
		}
		
		public int getBasicFare() { return BASIC_FARE; }
		abstract int fare(int distance);
	}
	
	public static void main(String [] args) {
		Transportation[] trans = Transportation.values();
		
		for(Transportation t : trans) {
			System.out.printf("%s fare = %d%n", t.name(), t.fare(100) );
		}
		
	}

}
