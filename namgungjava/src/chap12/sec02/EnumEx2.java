package chap12.sec02;

class SBE2 { // SandBox for Enum2
	enum Direction {
		EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");
		
		private static final Direction[] DIR_ARR = Direction.values();		
		private final int value;
		private final String symbol;
		
		Direction(int value, String symbol) {
			this.value = value;
			this.symbol = symbol;
		}
		
		public static Direction of(int dir) {
			if(dir <1 || dir>4) throw new IllegalArgumentException("Invalid avlue : " + dir);
			return DIR_ARR[dir - 1];
		}
		
		public int getValue() {
			return this.value;
		}
		public String getSymbol() {
			return this.symbol;
		}
		
		@Override
		public String toString() {
			return value + symbol;
		}
		
		public Direction rotate(int num) {
			num = num % 4;
			if( num < 0) num+=4; //������ �� �ð�ݴ��������
			
			return DIR_ARR[(value-1 + num) % 4];
		}
	}
}


public class EnumEx2 {
	//�ٸ� �ڹ� ���� ���ϰ� ��ġ�� ������ �ε��� Ŭ���� ������ enum�� �ִ´�.
	
	
	public static void main(String [] args) {
		for(SBE2.Direction d : SBE2.Direction.values()) {
			System.out.printf("%s = %d%s%n", d.name(), d.getValue(), d.getSymbol());
		}
		SBE2.Direction d1 = SBE2.Direction.EAST;
		SBE2.Direction d2 = SBE2.Direction.of(1);
		
		System.out.printf("d1 = %s%n", d1);
		System.out.printf("d2 = %s%n", d2);
		
		System.out.println("d1 == d2 : " + (d1==d2));
		
		System.out.println(SBE2.Direction.EAST.rotate(2));
		System.out.println(SBE2.Direction.EAST.rotate(1));
		System.out.println(SBE2.Direction.EAST.rotate(0));
		System.out.println(SBE2.Direction.EAST.rotate(-1));
		System.out.println(SBE2.Direction.EAST.rotate(-2));
		
		
		
	}

}
