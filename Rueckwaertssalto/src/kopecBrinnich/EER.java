package kopecBrinnich;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Dient zur Ausgabe eines EER-Diagramms
 * 
 * @author Selina Brinnich
 * @author Jakub Kopec
 * @version 2015-02-10
 *
 */
public class EER {

	private String filename;

	/**
	 * Definiert einen Filename fuer das Outputfile des EER
	 * @param filename der Filename des Outputfiles
	 */
	public EER(String filename){
		this.filename = filename;
	}
	
	/**
	 * Gibt ein EER-Diagramm in einem definierten Outputfile aus
	 * @param m ein Modell, welches die Meta-Daten einer DB gespeichert hat
	 */
	public void createOutputFile(Model m){
		createDotFile(m);
		
		try {
			Process proc = Runtime.getRuntime().exec("neato -Tpng " + filename + ".dot -o " + filename + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Erstellt ein [filename].dot File, dass als Grundlage fuer ein EER-Diagramm dient
	 * @param m ein Modell, welches die Meta-Daten einer DB gespeichert hat
	 */
	public void createDotFile(Model m) {
		// Open File-Writer
		BufferedWriter file = null;
		try {
			file = new BufferedWriter(new PrintWriter(filename + ".dot","UTF-8"));
		} catch (IOException e) {
			System.out.println("Error while opening file \"" + filename + ".dot\"");
		}

		try {
			file.write("graph EER {");
			file.newLine();
			
			//TABELLEN
			String[] t = m.getTables();
			for (int i = 0; i < t.length; i++) {
				file.write(t[i] + " [shape=box];");
				file.newLine();
				
				//ATTRIBUTE
				String[] a = m.getAttributes(t[i]);
				for(int j = 0; j < a.length; j++){
					file.write(t[i] + a[j]);
					if(m.isPrimaryKey(t[i], a[j])){
						file.write("[label=<<u>" + a[j] + "</u>>];");
					}else{
						file.write("[label=\"" + a[j] + "\"];");
					}
					
					file.newLine();
					file.write(t[i] + "--" + t[i] + a[j] + ";");
					file.newLine();
				}
			}
			
			//BEZIEHUNGEN & KARDINALITAETEN
			//TODO
			Relation[] rel = m.getRelations();
			String[] r;
			for(int i = 0; i < rel.length; i++){
				r = rel[i].getTables();
				file.write("bez" + i + "[shape=diamond label=\"\"];");
				file.newLine();
				file.write(r[0] + "--" + "bez" + i + "--" + r[1] + ";");
				file.newLine();
			}
			
			file.write("}");
		} catch (IOException e) {
			System.out.println("Error while writing DOT to file \"" + filename + ".dot\"");
		}

		// Close File-Writer
		try {
			file.close();
		} catch (IOException e) {
			System.out.println("Error while closing file \"" + filename + ".dot\"");
		}
		
	}
	
}
