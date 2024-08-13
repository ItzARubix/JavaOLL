import java.util.Stack;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class intepreter {
	public static void main(String[] args) throws IOException {

		File ollProgram = new File(args[0]);
		if(!ollProgram.exists()) {
			System.out.println("Your OLL program doesn't exist! Are you sure you entered the correct file path?");
			System.exit(0);
			//Not sure if "input file doesn't exist" counts as abnormal termination, but just go with it for now. 
		}

		Scanner readProgram = new Scanner(ollProgram);
		ArrayList<String> tokens = new ArrayList<String>();
		while(readProgram.hasNext()) {
			tokens.add(readProgram.next());
		}
		Stack<Integer> values = new Stack<Integer>();
		System.out.println(tokens.toString());
	}
}
