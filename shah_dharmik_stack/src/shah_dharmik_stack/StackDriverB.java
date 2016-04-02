package shah_dharmik_stack;

import java.util.Scanner;
import java.util.Stack;

public class StackDriverB {

	public static void main(String[] args) {
		String exp;
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter an expression: ");
		exp = in.nextLine();
		
		String[] brackets = exp.split(" ");
		
		if (balanced(brackets))
		{
			System.out.println("Balanced.");
		}
		else
		{
			System.out.println("Not balanced.");
		}
		
		in.close();
	}

	private static boolean balanced(String[] brackets) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0 ; i < brackets.length; i++)
		{
			if (brackets[i].equals("(")||brackets[i].equals("{")||brackets[i].equals("["))
			{
				System.out.println(brackets[i]);
				stack.push(brackets[i]);
			}
			else if (brackets[i].equals(")")||brackets[i].equals("}")||brackets[i].equals("]"))
			{
				if (stack.isEmpty() || !pair(stack.peek(),brackets[i]))
						{
					return false;
						}
				else
				{
					stack.pop();
				}
			}
		}
		return stack.isEmpty() ? true:false;
	}

	private static boolean pair(String opening, String closing) {
		if(opening.equals("(") && closing.equals(")")) return true;
		else if(opening.equals("{") && closing.equals("}")) return true;
		else if(opening.equals("[") && closing.equals("]")) return true;
		return false;
	}

}
