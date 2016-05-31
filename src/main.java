
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ALU alu =new ALU();
		//System.out.println(alu.floatRepresentation("0.00390625",4,8));
		//System.out.println(alu.integerRepresentation("-256", 9));
		System.out.println(alu.ieee754("1.0",32));
		//System.out.println(alu.integerTrueValue ("01111111"));
		System.out.println(alu.floatTrueValue (alu.ieee754("0.125",32),8,23));
	}

}
