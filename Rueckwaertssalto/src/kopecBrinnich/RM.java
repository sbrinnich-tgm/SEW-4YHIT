package kopecBrinnich;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Dient zur Ausgabe eines Relationenmodells
 * 
 * @author Selina Brinnich
 * @author Jakub Kopec
 * @version 2015-01-20
 *
 */
public class RM {

	private String filename;

	/**
	 * Definiert einen Filename fuer das Outputfile des RM
	 * @param filename der Filename des Outputfiles
	 */
	public RM(String filename){
		this.filename = filename;
	}

	/**
	 * Gibt ein Relationenmodell auf der Konsole aus
	 * @param m ein Modell, welches die Meta-Daten einer DB gespeichert hat
	 */
	public void createOutputCLI(Model m){
		String[] t = m.getTables();
		for(int i = 0; i < t.length; i++){
			System.out.print(t[i] + " (");
			String[] c = m.getAttributes(t[i]);
			for(int j = 0; j < c.length; j++){
				if(m.isPrimaryKey(t[i], c[j]))
					System.out.print("<PK>");
				if(m.isForeignKey(t[i], c[j])){
					String[] s = m.getForeignDescr(t[i], c[j]);
					System.out.print("<FK>" + c[j] + ":" + s[0] + "." + s[1]);
				}else{
					System.out.print(c[j]);
				}
				if(j != c.length-1){
					System.out.print(", ");
				}
			}
			System.out.println(")");
		}
	}

	/**
	 * Gibt ein Relationenmodell in einem definierten Outputfile aus
	 * @param m ein Modell, welches die Meta-Daten einer DB gespeichert hat
	 */
	public void createOutputFile(Model m){
		//Open File-Writer
		BufferedWriter file = null;
		try {
			file = new BufferedWriter(new PrintWriter(filename+".txt", "UTF-8"));
		} catch (IOException e) {
			System.out.println("Error while opening file \"" + filename + "\"");
		}

		try{
			String[] t = m.getTables();
			for (int i = 0; i < t.length; i++) {
				file.write(t[i] + " (");
				String[] c = m.getAttributes(t[i]);
				for (int j = 0; j < c.length; j++) {
					if (m.isPrimaryKey(t[i], c[j]))
						file.write("<PK>");
					if (m.isForeignKey(t[i], c[j])) {
						String[] s = m.getForeignDescr(t[i], c[j]);
						file.write("<FK>" + c[j] + ":" + s[0] + "." + s[1]);
					} else {
						file.write(c[j]);
					}
					if (j != c.length - 1) {
						file.write(", ");
					}
				}
				file.write(")");
				file.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error while writing RM to file \"" + filename + "\"");
		}

		// Close File-Writer
		try {
			file.close();
		} catch (IOException e) {
			System.out.println("Error while closing file \"" + filename + "\"");
		}
	}

	/**
	 * Gibt ein Relationenmodell in HTML-Format in einem definierten Outputfile aus
	 * @param m ein Modell, welches die Meta-Daten einer DB gespeichert hat
	 */
	public void createOutputHTML(Model m){
		//Open File-Writer
		BufferedWriter file = null;
		try {
			file = new BufferedWriter(new PrintWriter(filename+".html", "UTF-8"));
		} catch (IOException e) {
			System.out.println("Error while opening file \"" + filename + "\"");
		}
		try{
			file.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n \"http://www.w3.org/TR/html4/loose.dtd\">\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "<title>Relationenmodell</title>\n"
					+ "<style>\n"
					+ "font-family:'Calibri';\n"
					+ "</style>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "<p>\n");
			String[] t = m.getTables();
			boolean primary;
			for (int i = 0; i < t.length; i++) {
				file.write(t[i] + " (");
				String[] c = m.getAttributes(t[i]);
				for (int j = 0; j < c.length; j++) {
					primary = false;
					if (m.isPrimaryKey(t[i], c[j])){
						file.write("<u>");
						primary = true;
					}
					if (m.isForeignKey(t[i], c[j])) {
						String[] s = m.getForeignDescr(t[i], c[j]);
						file.write("<i>" + c[j] + ":" + s[0] + "." + s[1] + "</i>");
					} else {
						file.write(c[j]);
					}
					if(primary)
						file.write("</u>");
					if (j != c.length - 1) {
						file.write(", ");
					}
				}
				file.write(")<br />");
				file.newLine();
			}
			file.write("</p></body>\n</html>");
		} catch (IOException e) {
			System.out.println("Error while writing RM to file \"" + filename + "\"");
		}

		// Close File-Writer
		try {
			file.close();
		} catch (IOException e) {
			System.out.println("Error while closing file \"" + filename + "\"");
		}
	}

}
