package calculator;
import java.util.Scanner;
public class PostfixCalculator {
	private Calculator calculator;
	private IStack<String> num;
	private IStack<String> psfix;
	private IStack<String> tokens;
	
	public PostfixCalculator() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nIngresa el tipo de stack a crear: ");
		String stack = scan.nextLine();
		this.calculator = Calculator.getInstance();
		try {
			this.psfix = Factory.CreateStack(stack);
			this.num = Factory.CreateStack(stack);
			this.tokens = Factory.CreateStack(stack);
		}
		catch (Exception e) {
			this.num = null;
		}
		
		scan.close();
	}
	/**
	 * This method generates a stack of tokens the string of the text making a stack with them
	 * In case there are not equal parenthesis there would be a mistake
	 * In case is not a valid 
	 * @param scan, String to be put in tokens
	 * @return stack of tokens
	 */
	private IStack<String> tokenized(String scan){
		
		if( scan.length() <= 1 )  {
			return null;
		}else if(scan.length() > 1) {
			int op = 0 ;
			int cp = 0 ;
			int i = 0 ;
			while ( i < scan.length() ) {
				int j = i + 1 ;
				System.out.print("num: "+j+"\n");
				if( scan.substring(i , j).matches("\\s") ) {
					
//					System.out.print("Espacio: "+scan.substring(i, j)+"\n" ) ;
//					j++;
//					continue;
				}
				else if ( scan.substring(i, j).matches("[\\+\\-]?[\\d]+") ) {
					while ( j < scan.length() && scan.substring(i, j+1).matches("[\\d]+[\\.\\d]*") ) {
//						System.out.print(scan.substring(i, j)+"\n" ) ;
						j++;
					}
//					System.out.print("Valor: "+scan.substring(i, j)+"\n" ) ;
					this.tokens.push(scan.substring(i, j));
					
				}
				else if ( scan.substring(i, j).matches( "[\\+\\-\\*\\^\\/]?")) {
//					System.out.print(scan.substring(i, j)+"\n") ;
					this.tokens.push(scan.substring(i, j));
				}
				
				else if( scan.substring(i, j).matches("[\\(]?")) {
					System.out.print("Valor: "+scan.substring(i, j)+"\n") ;
					this.tokens.push(scan.substring(i, j));
					op++;
				}
				else if( scan.substring(i, j).matches("[\\)]?")) {
					System.out.print("Valor: "+scan.substring(i, j)+"\n") ;
					this.tokens.push(scan.substring(i, j));
					cp++;
				}
				else {
//					System.out.print("null");
					return null;
				}
				i = j;
				
			}
			if (cp == op) {
				
				int value =this.tokens.count();
				for (int k = 0 ; k < value ; k++ ) {
//					System.out.print("\n"+this.tokens.pull()+"\n");
				}
				return this.tokens;
			}
			return null;
			
		}
		return null;
	}
		
//	public Infix2Pstfix() {
//		
//	}

	
//	public boolean prueba() {
//		String scan = " scanner";
//		if (scan.substring(0, 1).matches("[\\s]+")) {
//			System.out.print(scan.substring(0, 1)+ "1yeah");
//			return true;
//		}else {
//			System.out.print(scan.substring(0, 1)+ "yeah");
//			return false;
//		}
//	}
	public static void main(String[] args) {
		PostfixCalculator calc = new PostfixCalculator();
//		System.out.print(calc.prueba());
		IStack<String> stack =calc.tokenized(" 1789 + 2 ");
		System.out.print(calc.tokenized("(1 + 2 * 12891.389)"));
		System.out.print(false+"\n");
		System.out.print(calc.tokenized("(1+2*12891.389)"));
		System.out.print("fjdksla\n");
		System.out.print(calc.tokenized("(1+2*12891.389"));
		System.out.print(calc.tokenized("(1+fjdskl*12891.389)"));
		
	}
	

}
