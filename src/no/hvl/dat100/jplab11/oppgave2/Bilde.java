package no.hvl.dat100.jplab11.oppgave2;

public class Bilde extends Tekst {
	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		likes = 0;
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BILDE\n" + id + "\n" + bruker + "\n" + dato + "\n" + likes + 
				"\n" + tekst + "\n" + url + "\n";
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		return "<h2>"+bruker+"@"+dato+" ["+likes+"]<h2>\n" + 
				"<p>"+tekst+"<p>\n" + 
				"<iframe src="+'"'+url+'"'+" height=600 width=800></iframe><hr>\n";
	}
}
