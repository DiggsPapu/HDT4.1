package calculator;

public class Calculator {
	
	private static volatile Calculator instance = null;
	private Calculator() {}
	
	public static Calculator getInstance() {
		if (instance == null) {
			synchronized(Calculator.class) {
				if (instance == null) {
					instance = new Calculator();
				}
			}
		}
		return instance;
	}
	
	
	
	public String add(String value2, String value1) {
		try{
			String result = String.valueOf(Float.parseFloat(value1)+Float.parseFloat(value2));
			return result;
		}
		catch(Exception e) {
			System.out.print("No es una operacion valida");
			return null;
		}
	}
	
	public String subs(String value2, String value1) {
		try{
			String result = String.valueOf(Float.parseFloat(value1)-Float.parseFloat(value2));
			return result;
		}
		catch(Exception e) {
			System.out.print("No es una operacion valida");
			return null;
		}
	}
	
	public String mult(String value2, String value1) {
		try{
			String result = String.valueOf(Float.parseFloat(value1)*Float.parseFloat(value2));
			return result;
		}
		catch(Exception e) {
			System.out.print("No es una operacion valida");
			return null;
		}
	}
	
	public String div(String value2, String value1) {
		try{
			String result = String.valueOf(Float.parseFloat(value1)/Float.parseFloat(value2));
			return result;
		}
		catch(Exception e) {
			System.out.print("No es una operacion valida");
			return null;
		}
	}
	
	public String exp(String value2, String value1) {
		try{
			String result = String.valueOf(Math.pow(Double.parseDouble(value1), Double.parseDouble(value2)));
			return result;
		}
		catch(Exception e) {
			System.out.print("No es una operacion valida");
			return null;
		}
	}
}
