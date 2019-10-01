package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class NameFactory {
	private static final String FIRST_NAMES_SRC = "First_Names.txt";
	private static final String LAST_NAMES_SRC = "Last_Names.txt";
	private LinkedList<String> firstNames, lastNames;
	
	public NameFactory() {
		try {
			firstNames = loadFirstNames();
			lastNames = loadLastNames();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String emitFirstName() {
		return firstNames.get((int)(Math.random() * firstNames.size()));
	}
	
	public String emitLastName() {
		return lastNames.get((int)(Math.random() * firstNames.size()));
	}
	
	private LinkedList<String> loadFirstNames() throws FileNotFoundException {
		LinkedList<String> list = new LinkedList<>();
		Scanner in = new Scanner(new File(FIRST_NAMES_SRC));
		while (in.hasNextLine()) {
			list.add(in.nextLine());
		}
		in.close();
		return list;
	}
	
	private LinkedList<String> loadLastNames() throws FileNotFoundException {
		LinkedList<String> list = new LinkedList<>();
		Scanner in = new Scanner(new File(LAST_NAMES_SRC));
		while (in.hasNextLine()) {
			list.add(in.nextLine());
		}
		in.close();
		return list;
	}
}
