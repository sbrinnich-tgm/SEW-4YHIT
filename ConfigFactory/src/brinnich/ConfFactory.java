package brinnich;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ConfFactory {
	
	public void writeConfig(String filename){
		BufferedWriter file = null;

		try {
			file = new BufferedWriter(new PrintWriter(filename, "UTF-8"));
		} catch (Exception e) {
			System.err.println("Could not create output-file '" + filename + "'.");
		}
		try {
			file.write(createElement("adapter","adapter1").getString());
			file.newLine();
			file.write(createElement("user","user1").getString());
			file.newLine();
			file.write(createElement("password","password1").getString());
		} catch (Exception e) {
			System.err.println("Could not write to file.");
		}
		
		try {
			file.close();
		} catch (IOException e) {
			System.err.println("Could not close output-file.");
		}
	}

	public abstract Element createElement(String type, String value);
	
}
