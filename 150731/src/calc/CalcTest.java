package calc;

public class CalcTest {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 2;
		
		ICalc calc = new Calculator();
		
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.sub(num1, num2));
		System.out.println(calc.times(num1, num2));
		System.out.println(calc.divide(num1, num2));
	}

}
