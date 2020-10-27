package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		File fil = new File(mappe+filnavn);
		Blogg blogg;
		try {
			Scanner leser = new Scanner(fil);
			int lengde = Integer.parseInt(leser.nextLine());
			blogg = new Blogg(lengde);
			for (int e = 0; e < lengde; e++) {
				String type = leser.nextLine();
				int id = Integer.parseInt(leser.nextLine());
				String navn = leser.nextLine();
				String dato = leser.nextLine();
				int likes = Integer.parseInt(leser.nextLine());
				
				if (type.equals(TEKST)) {
					String tekst = leser.nextLine();
					Tekst innlegg = new Tekst(id,navn,dato,likes,tekst);
					blogg.leggTil(innlegg);
				} else if (type.equals(BILDE)) {
					String tekst = leser.nextLine();
					String url = leser.nextLine();
					Bilde innlegg = new Bilde(id,navn,dato,likes,tekst,url);
					blogg.leggTil(innlegg);
				}
			}
			leser.close();
			return blogg;
		}catch (FileNotFoundException e) {
			System.out.print("Kunne ikke finne filen: " + mappe + filnavn);
		}
		return null;

	}
}
