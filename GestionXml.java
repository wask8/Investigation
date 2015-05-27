package investigation;

import java.io.*;

import org.jdom.*; //ajouter JDOM a la librairie (visiblement pas présent de base)
import org.jdom.output.*;
import org.w3c.dom.Element;

public class GestionXml {
	//Nous allons commencer notre arborescence en créant la racine XML
	//qui sera ici "investigation".
	static Element racine = new Element("investigation");
	
	static org.jdom.Document document = new Document(racine);
	
	 public static void main(String[] args)
	   {
	      //On crée un nouvel Element etudiant et on l'ajoute
	      //en tant qu'Element de racine
	      Element carte = new Element("carte");
	      racine.addContent(carte);
	      Attribute mode = new Attribute("mode","histoire");
	      carte.setAttribute(mode);
	      
	      Element point = new Element("point");
	      carte.addContent(point);
	      	      
	      Element ville = new Element("ville");
	      ville.setText("Laval");
	      point.addContent(ville);
	      
	      Element coordonnees = new Element("coordonnees")
	      coordonnees.setText(/* COORDONNEES */);
	      point.addContent(coordonnees);
	      
	      Element score = new Element("score");
	      racine.addContent(score);
	      
	      Element pseudo = new Element("pseudo");
	      score.addContent(pseudo);
	      
	      Element scoreJoueur = new Element("scoreJoueur");
	      score.addContent(scoreJoueur);
}
