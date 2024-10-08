import java.util.Stack;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class interpreter {
	public static void main(String[] args) {

		if(args.length == 0) {
			System.out.println("No file selected. \nPlease run the OLL command followed by the path to the OLL file you want to execute.");
			System.exit(1);
		}
		
	
		try {
		
			File ollProgram = new File(args[0]);
			if(!ollProgram.exists()) {
				System.out.println("Could not find the OLL file that you entered. \nPlease run the OLL command followed by the path to the OLL file you want to execute.");
				System.exit(2);
			}
			Scanner readProgram = new Scanner(ollProgram);
			ArrayList<String> tokens = new ArrayList<String>();
			ArrayList<Integer> labels = new ArrayList<Integer>();
			
			while(readProgram.hasNext()) {
				
				String opcode = readProgram.next();
				if(opcode.endsWith(":")) {
					tokens.add(opcode);
					labels.add(tokens.size()-1);
				} else {
					switch(opcode) {
						case "HALT":
						case "READ":
						case "ADD":
						case "SUB":
						case "POP":
							tokens.add(opcode);
							break;
						case "":
							break;
						case "PUSH":
						case "JUMP.EQ.0":
						case "JUMP.GT.0":
							tokens.add(opcode);
							tokens.add(readProgram.next());
							break;
						case "PRINT":
							tokens.add(opcode);
							tokens.add(readProgram.nextLine());
							break;
					}
				}
				
			}
			readProgram.close();
			Stack<Integer> values = new Stack<Integer>();
			Scanner userInput = new Scanner(System.in);
			int a = 0;
			int b = 0;
									
			for(int tokenPointer = 0; tokenPointer<tokens.size() && tokens.get(tokenPointer)!="HALT"; tokenPointer++) {
				switch(tokens.get(tokenPointer)) {
					case "PUSH":
						tokenPointer++;
						values.push(Integer.parseInt(tokens.get(tokenPointer)));//must be converted to integer before being pushed
						break;
					case "POP":
						values.pop();
						break;
					case "ADD":
						a = values.pop();
						b = values.pop();
						values.push(a+b);
						break;
					case "SUB":
						a = values.pop();
						b = values.pop();
						values.push(b-a);
						break;
					case "PRINT":
						tokenPointer++;
						String unformattedString = tokens.get(tokenPointer);
						int initialQuote = unformattedString.indexOf("\"");
						System.out.println(unformattedString.substring(initialQuote+1, unformattedString.indexOf("\"", initialQuote+1)));
						//This code is completely perfect. I will be accepting no criticism
						break;
					case "READ":
						values.push(userInput.nextInt());
						break;
					case "JUMP.EQ.0":
						tokenPointer++;
						if(values.peek() == 0) {
							for(int i = 0; i<labels.size(); i++) {
								
								if(tokens.get(tokenPointer).equals(tokens.get(labels.get(i)).substring(0, tokens.get(labels.get(i)).length()-1))) { //Copy what is on line 97
									tokenPointer = labels.get(i);
								}
							}
						}
						break;
					case "JUMP.GT.0": 
						tokenPointer++;
						if(values.peek() == 0) {
							for(int i = 0; i<labels.size(); i++) {
								//tokens.get(tokenPointer).equals(tokens.get(labels.get(i)).substring(0, tokens.get(tokenPointer).indexOf(":")))
								if(tokens.get(tokenPointer).equals(tokens.get(labels.get(i)).substring(0, tokens.get(labels.get(i)).length()-1))) { //Copy what is on line 87
									tokenPointer = labels.get(i);
								}
							}
						}
						break;
					case "HALT":
						System.exit(0);
						break;
				}
			}
			
			
			
		} catch(Exception e) {
			System.out.println("An unknown exception occurred. This may be due to a syntax error or runtime error in your program.");
			System.out.println("For educational purposes, you may read the exception and attempt to diagnose the issue.");
			System.out.println("Unless you're familiar with the source code of the interpreter, this will likely not make sense to you.");
			System.out.println(e);
		}
	}
}
