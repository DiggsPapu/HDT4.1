package calculator;

public class Calculator {
	
	private static volatile Calculator instance = null;
	/**
	 * The calculator constructor is private because in this case it will not create more instances of calculator
	 */
	private Calculator() {}
	/**
	 * Is the SINGLETON method to create the calculator
	 * @return calculator, if it is already created it returns the same calculator
	 */
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
	
	
	/**
	 * It is the method to do sums
	 * @param value2
	 * @param value1
	 * @return result as a string in case it is valid to do the operation.
	 */
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
	/**
	 * It is the method to do subs
	 * @param value2
	 * @param value1
	 * @return result as a string in case it is valid to do the operation.
	 */
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
	/**
	 * It is the method to do multiplication
	 * @param value2
	 * @param value1
	 * @return result as a string in case it is valid to do the operation.
	 */
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
	/**
	 * It is the method to do divisions
	 * @param value2
	 * @param value1
	 * @return result as a string in case it is valid to do the operation.
	 */
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
	/**
	 * It is the method to do exponentials
	 * @param value2
	 * @param value1
	 * @return result as a string in case it is valid to do the operation.
	 */
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
