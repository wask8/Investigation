package xmlFactory;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLGestion {

	
	Document document;
	
	private Element racine;
	
	private DocumentBuilder builder;
	
	private int nbVille;
	private int nbLieux;
	private int nbCampus;
	private int nbSalles;
	
	private int nbTexte;


	public XMLGestion(DocumentBuilder builder) throws SAXException, IOException {

		this.builder = builder;

		final Document document= builder.parse(new File("donnees.xml"));
		this.document = document;

		final Element racine = document.getDocumentElement();
		this.racine = racine;


		final NodeList ville= racine.getElementsByTagName("ville_scénario");
		nbVille = ville.getLength();

		final NodeList lieu= racine.getElementsByTagName("lieu_scénario");
		nbLieux = lieu.getLength();

		final NodeList campus = racine.getElementsByTagName("campus_scénario");
		nbCampus = campus.getLength();
		
		final NodeList salle = racine.getElementsByTagName("salle_IUT");
		nbSalles = salle.getLength();

	}
	
	//Ajouter un élément//
	public void ajoutElement(int objet, String nomElement, String phrase, int coordonneeX1, int coordonneeY1, String URLcarte) throws SAXException, IOException {
		
		String x = ""+coordonneeX1;
		String y = ""+coordonneeY1;
		
		Node elem = document.getFirstChild();

		String str1 = null;

		if (objet == 0) {
			str1 = "ville";
		}
		else if (objet == 1) {
			str1 = "lieux";
		}
		else if (objet == 2){
			str1 = "campus";
		}else if(objet == 3)
			str1 = "salle";


		elem = document.createElement(str1);
		racine.appendChild(elem);	

		final Element nom = document.createElement("nom");
		nom.appendChild(document.createTextNode(nomElement));
		
		final Element phrase1 = document.createElement("phrase");
		phrase1.appendChild(document.createTextNode(phrase));
		
		final Element URL = document.createElement("URL");
		URL.appendChild(document.createTextNode(URLcarte));

		final Element coordonneeX = document.createElement("coordonneeX");
		coordonneeX.appendChild(document.createTextNode(x));

		final Element coordonneeY = document.createElement("coordonneeY");
		coordonneeY.appendChild(document.createTextNode(y));

		elem.appendChild(nom);
		elem.appendChild(coordonneeX);
		elem.appendChild(coordonneeY);
		elem.appendChild(phrase1);
		elem.appendChild(URL);
		
		racine.appendChild(elem);
	}
	
	
	public void ajoutJoueur(String nomJoueur, int score) throws SAXException, IOException {
		
		String a = ""+score;

		Node elem = document.getFirstChild();

		elem = document.createElement("joueur");
		racine.appendChild(elem);	

		final Element nom = document.createElement("nom");
		nom.appendChild(document.createTextNode(nomJoueur));

		final Element score_a = document.createElement("score");
		score_a.appendChild(document.createTextNode(a));

		elem.appendChild(nom);
		elem.appendChild(score_a);
		racine.appendChild(elem);
	}
	
	//Lire le score//
	public int lectureScoreJoueur(int position) {
		String str = null;

		final NodeList racineNoeuds = racine.getElementsByTagName("joueur");

		if(racineNoeuds.item(position).getNodeType() == Node.ELEMENT_NODE) {

			final Element carte = (Element) racineNoeuds.item(position);
			final Element score = (Element) carte.getElementsByTagName("score").item(0);
			str = score.getTextContent();
		}
		int i = Integer.parseInt(str); 
		return i;

	}

	
	
	/*GET & SET */
	
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Element getRacine() {
		return racine;
	}

	public void setRacine(Element racine) {
		this.racine = racine;
	}

	public DocumentBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(DocumentBuilder builder) {
		this.builder = builder;
	}

	public int getNbVille() {
		return nbVille;
	}

	public void setNbVille(int nbVille) {
		this.nbVille = nbVille;
	}

	public int getNbLieux() {
		return nbLieux;
	}

	public void setNbLieux(int nbLieux) {
		this.nbLieux = nbLieux;
	}

	public int getNbCampus() {
		return nbCampus;
	}

	public void setNbCampus(int nbCampus) {
		this.nbCampus = nbCampus;
	}

	public int getNbSalles() {
		return nbSalles;
	}

	public void setNbSalles(int nbSalles) {
		this.nbSalles = nbSalles;
	}

	public int getNbTexte() {
		return nbTexte;
	}

	public void setNbTexte(int nbTexte) {
		this.nbTexte = nbTexte;
	}
	
	
	

	
}
