package calc;

public class Calculator implements ICalc{

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if( num2 == 0 ){
			System.out.println("0으로 나눌 수 없습니다");
			return -999999;
		}
		return num1 / num2;
	}

	
}
