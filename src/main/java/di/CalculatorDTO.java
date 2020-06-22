package di;

public class CalculatorDTO {
	
	//멤버변수
	Calculator cal;
	private int firstNum;
	private int SecondNum;
	
	//멤버메소드
	/*
	Calculator 클래스에 정의된 사칙연산 메소드를 각각 호출하는 
	역할만 수행하는 4가지 메소드를 정의함.
	*/
	public double add() {
		return cal.adder(firstNum, SecondNum);
	}
	public double sub() {
		return cal.sub(firstNum, SecondNum);
	}
	public double mul() {
		return cal.multi(firstNum, SecondNum);
	}
	public double div() {
		return cal.divide(firstNum, SecondNum);
	}
	
	// getter / setter
	public Calculator getCal() {
		return cal;
	}
	public void setCal(Calculator cal) {
		this.cal = cal;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return SecondNum;
	}
	public void setSecondNum(int secondNum) {
		SecondNum = secondNum;
	}
	
}
