package calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
/**
 * It is to read and get the string with the operation in the text file
 * @param dir
 * @return String, string with the operation instruction
 */
	private static String addFileText(String dir) {
		try {
			
			BufferedReader read= new BufferedReader(new FileReader(dir));
			String operation = read.readLine();
	
			read.close();
			System.out.print("\n");
			return operation;   
			   
			}
		
		
		catch (Exception e) {
			System.out.print("\nEl archivo no es posible de abrir\n");

			return null;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scann = new Scanner(System.in);
		
		
		System.out.print("Ingrese la direccion del archivo a abrir: ");
		String dir = scann.nextLine();
		
		System.out.print("\nIngrese el tipo de dato con el que se trabajaran las operaciones (List, ArrayList, Vector): ");
		String scan = scann.nextLine();
		
		if (scan.equals("Vector")) {
			
			String operation=Main.addFileText(dir);
			PostfixCalculator calc = new PostfixCalculator(scan);
			//C:\Users\Windows 10\Documents\UVG\CODING\Algoritmos y estructuras de datos\HDT\HDT4 Repo\Others\datos.txt    
			//DoubleLinkedList
			//LinkedList
			System.out.print("Resultado: "+calc.calculate(operation)); 
		}else if (scan.equals("ArrayList")) {
			String operation=Main.addFileText(dir);
			PostfixCalculator calc = new PostfixCalculator(scan);
			System.out.print("Resultado: "+calc.calculate(operation));
			
		}else if (scan.equals("List")) {
			String operation=Main.addFileText(dir);
			PostfixCalculator calc = new PostfixCalculator(scan);
			
			System.out.print("Resultado: "+calc.calculate(operation));
		}else {
			System.out.print("\nNo es valido\n");
		}
		scann.close();
	} 

}
