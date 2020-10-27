package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.oppgave3.*;

import java.io.File;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		File fil = new File(mappe + filnavn);
		try {
			PrintWriter skriver = new PrintWriter(fil);
			String str = samling.toString();
			skriver.write(str);
			
			skriver.close();
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}
}
