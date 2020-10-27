package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;

public class Blogg {
	protected Innlegg[] innleggtabell;
	protected int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) != -1);
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (ledigPlass() && !finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} 
		return false;
	}
	
	public String toString() {
		String str = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			str = str + innleggtabell[i].toString();
		}
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[innleggtabell.length*2];
		for (int i = 0; i < innleggtabell.length; i++) {
			nyTabell[i] = innleggtabell[i];
		}
		innleggtabell = nyTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			if (!ledigPlass()) {
				utvid();
			}
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		if (finnes(innlegg)) {
			innleggtabell[finnInnlegg(innlegg)] = innleggtabell[nesteledig-1];
			nesteledig--;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		int[] id = new int[nesteledig];
		int index = 0;
		for (int i = 0; i < nesteledig; i++) {
			String str = ((Tekst)innleggtabell[i]).getTekst();
			if (str.contains(keyword)) {
				id[index] = innleggtabell[i].getId();
				index++;
			}
		}
		int[] nyId = new int[index];
		for (int e = 0; e < index; e++) {
			nyId[e] = id[e];
		}
		return nyId;
	}
}