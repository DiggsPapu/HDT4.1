package calculator;
import java.util.Scanner;
public class PostfixCalculator {
	private Calculator calculator;
	private String type;
	private IStack<String> op;
	private IStack<String> psfix;
	private IStack<String> tokens;
	
	public PostfixCalculator(String stack) {
		Scanner scan = new Scanner(System.in);
		this.type = stack;
		this.calculator = Calculator.getInstance();
//		System.out.print(this.calculator.hashCode());
		try {
			this.psfix = Factory.CreateStack(stack);
			this.op = Factory.CreateStack(stack);
			this.tokens = Factory.CreateStack(stack);
		}
		catch (Exception e) {
			this.op = null;
			this.psfix = null;
			this.tokens = null;
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
//				System.out.print("num: "+j+"\n");
				if( scan.substring(i , j).matches("\\s") ) {
					
//					System.out.print("Espacio: "+scan.substring(i, j)+"\n" ) ;
//					j++;
//					continue;
				}
				else if ( scan.substring(i, j).matches("[\\d]+") ) {
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
//					System.out.print("Valor: "+scan.substring(i, j)+"\n") ;
					this.tokens.push(scan.substring(i, j));
					op++;
				}
				else if( scan.substring(i, j).matches("[\\)]?")) {
//					System.out.print("Valor: "+scan.substring(i, j)+"\n") ;
					this.tokens.push(scan.substring(i, j));
					cp++;
				}
				else {
//					It empties the tokens if it is a mistake
					while (!this.tokens.isEmpty()) {
						this.tokens.pull();
					}
					return null;
				}
				i = j;
				
			}
			if (cp == op) {
				//Se vacia tokens
				int value =this.tokens.count();
				IStack<String> inversed = Factory.CreateStack(this.type);
//				System.out.print("INVERSED: "+inversed.isEmpty());
				for (int k = 0 ; k < value ; k++ ) {
					inversed.push(this.tokens.pull());
				}
				
				
				return inversed;
			}
//			It empties the tokens if it is a mistake
			while (!this.tokens.isEmpty()) {
				this.tokens.pull();
			}
			return null;
			
		}
//		It empties the tokens if it is a mistake
		while (!this.tokens.isEmpty()) {
			this.tokens.pull();
		}
		return null;
	}
	/**
	 * This method transforms the infix expression into postfix expression with the type of stack 	
	 * @param stack
	 * @return
	 */
	private IStack<String> Infix2Pstfix(IStack<String> stack) {
		if (stack != null) {
//			System.out.print(stack.count());
			
//			System.out.print("Op is empty1: "+this.op.isEmpty()+ "Pstfix is empty1: "+ this.psfix.isEmpty()+"tokens is empty: "+  this.tokens.isEmpty());
			
			int size = stack.count();
			
//			for (int k = 0 ; k < size ; k++ ) {
//				System.out.print(stack.pull());
//			}
			for (int k = 0 ; k < size ; k++ ) {
//				System.out.print(k);
//				System.out.print("\nStack: ");
//				System.out.print("\n"+stack.peek()+stack.count()+"\n");
				//If the token is a number, it is stored in the final postfix
				if(stack.peek().matches("[\\d]+[\\.\\d]*")) {
						this.psfix.push(stack.pull());
					
//					System.out.print("\nEntro a num: "+ this.psfix.peek()+"\n");
				}
				
				else if (stack.peek().matches("[\\*\\/\\+\\-\\^\\(]?") && this.op.isEmpty()){
					this.op.push(stack.pull());
//					System.out.print("Entro a operacion vacia: "+ op.peek()+"\n");
					
				}
				//In case the token is exp, it will be stored in the operations stack if the peek is an operation except exp
				else if (stack.peek().matches("[\\^]") && this.op.peek().matches("[\\*\\/\\+\\-\\(]?")){
					this.op.push(stack.pull());
//					System.out.print("\nEntro a op: "+ this.op.peek()+"\n");
				}
				//if it is a mult or div it will be stored in operations stack if it doesn't match mult, div or exp
				else if (stack.peek().equals("*") || stack.peek().equals("/") && !this.op.peek().equals("*") && !this.op.peek().equals("/")) {
					this.op.push(stack.pull());
//					System.out.print("\nEntro a op: "+ this.op.peek()+"\n");
				}
				//In case we have a mult or div in tokens and we have an equal or superior token it will be taken out until there is a 
				//open parenthesis or none tokens. And then the token's peek will be stored in the operations stack
				else if (stack.peek().equals("[\\*\\/]? ") && this.op.peek().equals("[\\*\\/\\^]?")) {
					int size1 = this.op.count();
					int j = 0 ;
					while (j < size1 && !this.op.peek().equals("(")) {
						this.psfix.push(this.op.pull());
						j++ ;
					}
					this.op.push(stack.pull());
//					System.out.print("Entro a cambio: "+this.op.peek());
					
				}
				//If the peek is sum or subs and the op peek doesn't match equal or superior token
				else if (stack.peek().matches("[\\+\\-]?" ) &&  !this.op.peek().matches("[\\*\\/\\+\\-]?")) {
					this.op.push(stack.pull());

//					System.out.print("Ingreso a restas y sumas: "+ op.peek());
					
				}
				//If the token's peek is sum or subs and the op' s peek matches equal or superior token
				//It will take out all the tokens until there is a open parenthesis peek or until there are none tokens
				//Then the token's peek will be stored in the operations stack.
				else if (stack.peek().matches("[\\+\\-]?" ) &&  this.op.peek().matches("[\\*\\/\\+\\-]?")) {
					int size1 = this.op.count();
					int j = 0 ;
					while (j < size1 && !this.op.peek().equals("(")) {
						this.psfix.push(this.op.pull());
						j++ ;
					}
					this.op.push(stack.pull());
//					System.out.print("Ingreso a ssumas y restas: "+ op.peek());
				}
				//In case the token's peek is a open parenthesis it is always stored in the stack
				else if (stack.peek().equals("(")) {
					this.op.push(stack.pull());
					
				}
				//In case the token's peek is a closed parenthesis, it will take all the token's until it founds a open parenthesis
				//Or the operations is empty, then it will take out the open parenthesis and the closed parenthesis
				else if (stack.peek().equals(")")) {
//					System.out.print("Entro a parentesis cerrado");
					while (!this.op.peek().equals("(") && !op.isEmpty()) {
						this.psfix.push(this.op.pull());
//						System.out.print(this.psfix.peek());
					}
					this.op.pull();
					stack.pull();
				}
				
			}
			
			while (!op.isEmpty()) {
				this.psfix.push(op.pull());
			}
			int sizef = this.psfix.count();
			IStack<String> postfix = Factory.CreateStack(this.type);
//			System.out.print("Postfix: ");
			for (int k = 0 ; k < sizef ; k++) {
				postfix.push(this.psfix.pull());
//				System.out.print(postfix.peek()+" ");
			}
			
//			System.out.print("Postfix is empty: "+psfix.isEmpty()+"Op is empty: "+op.isEmpty()+"\n");
			return postfix;
		}
		else {
			
			return null;
		}
	}
	/**
	 * This method makes the calculation of a postfix expresion
	 * @param stack, it enters the stack 
	 * @return the string with the calculation
	 */
	private String postfixCalculation(IStack<String> stack) {
		if(stack!=null) {
			int counter = stack.count();
//			System.out.print("Este es el counter: "+ counter);
			for(int k = 0 ; k < counter ; k ++) {
//				System.out.print(stack.peek());
				if (stack.peek().matches("[\\d]+[\\.\\d]*")) {
					this.psfix.push(stack.pull());
//					System.out.print("Entro a numero: "+ this.psfix.peek()+"\n");
				}
				else if (stack.peek().equals("*")) {
					try {

//						System.out.print("Entro a mult: "+ stack.peek()+"\n");
						this.psfix.push(this.calculator.mult(this.psfix.pull(), this.psfix.pull()));
//						System.out.print(this.psfix.peek()+"\n");
						stack.pull();
					}
					catch (Exception e) {
						System.out.print("No es una expresion valida\n");
						return null;
					}
				}
				else if (stack.peek().equals("/")) {					
					try {
//						System.out.print("Entro a div: "+ this.psfix.peek()+"\n");
						
						this.psfix.push(this.calculator.div(this.psfix.pull(), this.psfix.pull()));
//						System.out.print(this.psfix.peek()+"\n");
						stack.pull();
					}
					catch (Exception e) {
						System.out.print("No es una expresion valida\n");
						return null;
					}
				}
				else if (stack.peek().equals("+")) {
					
					try {
//						System.out.print("Entro a suma: "+ this.psfix.peek()+"\n");
						String value2 = this.psfix.pull();
						String value1 = this.psfix.pull();
//						System.out.print(value2+value1);
						this.psfix.push(this.calculator.add(value2, value1));
//						System.out.print(this.psfix.peek()+"\n");
						stack.pull();
					}
					catch (Exception e) {
						System.out.print("No es una expresion valida\n");
						return null;
					}

				}
				else if (stack.peek().equals("-")) {
					try {
//						System.out.print("Entro a subs: "+ this.psfix.peek()+"\n");
						this.psfix.push(this.calculator.subs(this.psfix.pull(), this.psfix.pull()));
//						System.out.print(this.psfix.peek()+"\n");
						stack.pull();
					}
					catch (Exception e) {
						System.out.print("No es una expresion valida\n");
						return null;
					}

				}
				else if (stack.peek().equals("^")) {
					try {
//						System.out.print("Entro a exp: "+ this.psfix.peek()+"\n");
						this.psfix.push(this.calculator.exp(this.psfix.pull(), this.psfix.pull()));
//						System.out.print(this.psfix.peek()+"\n");
						stack.pull();
					}
					catch (Exception e) {
						System.out.print("No es una expresion valida\n");
						return null;
					}

				}
			}
			String result = new String(psfix.peek());
			psfix.pull();
//			System.out.print(psfix.isEmpty());
			return result;
		}else {
			return null;
		}
	}
	/**
	 * Method to calculate all, using the private methods
	 * @param scan
	 * @return String with the result, in case it is null, it means the operation could not be done
	 */
	public String calculate(String scan) {
		return postfixCalculation(Infix2Pstfix(tokenized(scan)));
	}

	public static void main(String[] args) {
		PostfixCalculator calc = new PostfixCalculator("Vector");
		System.out.print(calc.tokenized("(1 + 2 * 12891.389)")+"\n");
		System.out.print(calc.tokenized("(1+2*12891.389)")+"\n");
//		System.out.print("fjdksla\n");
		System.out.print(calc.tokenized("(1+2*12891.389")+"\n");
		System.out.print(calc.tokenized("(1+fjdskl*12891.389)")+"\n");
//		System.out.print("\n\n\nOperacion1\n\n\n");
		System.out.print(calc.Infix2Pstfix(calc.tokenized("3+2"))+"\n");
		System.out.print(calc.Infix2Pstfix(calc.tokenized("(4+5*(1+3*(25-4)+25*3))"))+"\n");
		System.out.print(calc.postfixCalculation((calc.Infix2Pstfix(calc.tokenized("(4+5*(1+3*(25-4)+25*3))"))))+"\n");
		System.out.print(calc.postfixCalculation((calc.Infix2Pstfix(calc.tokenized("4+5"))))+"\n");
		PostfixCalculator calc1 = new PostfixCalculator("ArrayList");
		System.out.print("\n");
		System.out.print(calc1.tokenized("(1 + 2 * 12891.389)")+"\n");
		System.out.print(calc1.tokenized("(1+2*12891.389)")+"\n");
//		System.out.print("fjdksla\n");
		System.out.print(calc1.tokenized("(1+2*12891.389")+"\n");
		System.out.print(calc1.tokenized("(1+fjdskl*12891.389)")+"\n");
//		System.out.print("\n\n\nOperacion1\n\n\n");
		System.out.print(calc1.Infix2Pstfix(calc1.tokenized("3+2"))+"\n");
		System.out.print(calc1.Infix2Pstfix(calc1.tokenized("(4+5*(1+3*(25-4)+25*3))"))+"\n");
		System.out.print(calc1.postfixCalculation((calc1.Infix2Pstfix(calc1.tokenized("(4+5*(1+3*(25-4)+25*3))"))))+"\n");
		System.out.print(calc1.postfixCalculation((calc1.Infix2Pstfix(calc1.tokenized("4+5"))))+"\n");
		System.out.print(calc1.postfixCalculation((calc1.Infix2Pstfix(calc1.tokenized("20*50"))))+"\n");
		System.out.print(calc1.postfixCalculation((calc1.Infix2Pstfix(calc1.tokenized("20+10*"))))+"\n");
		System.out.print(calc1.calculate("1+1")+"\n");
		System.out.print(calc1.calculate("27* (24+36/0)")+"\n");
		System.out.print(calc1.calculate("27* (24-36/0)")+"\n");

		System.out.print(calc1.calculate("27* (24+36/0")+"\n");

		System.out.print(calc1.calculate("27* (24++36/0)")+"\n");

		System.out.print(calc1.calculate("27* (fjdskal+36/0)")+"\n");
	}
	

}
