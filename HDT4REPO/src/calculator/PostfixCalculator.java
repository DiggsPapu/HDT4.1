package calculator;
import java.util.Scanner;
public class PostfixCalculator {
	private Calculator calculator;
	private IStack<String> num;
	private IStack<String> psfix;
	
	public PostfixCalculator() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nIngresa el tipo de stack a crear: ");
		String stack = scan.nextLine();
		this.calculator = Calculator.getInstance();
		try {
			this.psfix = Factory.CreateStack(stack);
			this.num = Factory.CreateStack(stack);
		}
		catch (Exception e) {
			this.num = null;
		}
		
		scan.close();
	}
	
	
}
