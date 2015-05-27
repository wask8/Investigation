package investigation;

import java.io.*;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	      //On crée un nouvel Element carte et on l'ajoute
	      //en tant qu'Element de racine
	      Element carte = new Element("carte");
	      racine.addContent(carte);
	      Attribute mode = new Attribute("mode","histoire");
	      carte.setAttribute(mode);
	      
	      //On crée un nouvel Element point et on l'ajoute
	      //en tant qu'Element de carte
	      Element point = new Element("point");
	      carte.addContent(point);
	      
	      //On crée un nouvel Element ville et on l'ajoute
	      //en tant qu'Element de point	      
	      Element ville = new Element("ville");
	      ville.setText("Laval");
	      point.addContent(ville);
	      
	      //On crée un nouvel Element coordonnees et on l'ajoute
	      //en tant qu'Element de point
	      Element coordonnees = new Element("coordonnees")
	      coordonnees.setText(/* COORDONNEES */);
	      point.addContent(coordonnees);
	      
	      //On crée un nouvel Element score et on l'ajoute
	      //en tant qu'Element de racine
	      Element score = new Element("score");
	      racine.addContent(score);
	      
	      //On crée un nouvel Element pseudo et on l'ajoute
	      //en tant qu'Element de score
	      Element pseudo = new Element("pseudo");
	      score.addContent(pseudo);
	      
	      //On crée un nouvel Element scoreJoueur et on l'ajoute
	      //en tant qu'Element de score
	      Element scoreJoueur = new Element("scoreJoueur");
	      score.addContent(scoreJoueur);
	      
	      affiche();
	      enregistre("data.xml");

	      static void affiche()
	      {
	         try
	         {
	            //On utilise ici un affichage classique avec getPrettyFormat()
	            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	            sortie.output(document, System.out);
	         }
	         catch (java.io.IOException e){}
	      }

	      static void enregistre(String fichier)
	      {
	         try
	         {
	            //On utilise ici un affichage classique avec getPrettyFormat()
	            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	            //Il suffit simplement de créer une instance de FileOutputStream
	            //avec en argument le nom du fichier pour effectuer la sérialisation.
	            sortie.output(document, new FileOutputStream(fichier));
	         }
	         catch (java.io.IOException e){}
	      }
	   
	      static void afficheScore()
	      {
	         //On crée une List contenant tous les noeuds "score" de l'Element racine
	         List listScores = racine.getChildren("score");

	         //On crée un Iterator sur notre liste
	         Iterator i = listScores.iterator();
	         while(i.hasNext())
	         {
	            //On recrée l'Element courant à chaque tour de boucle afin de
	            //pouvoir utiliser les méthodes propres aux Element comme :
	            //sélectionner un nœud fils, modifier du texte, etc...
	            Element courant = (Element)i.next();
	            //On affiche le nom de l’élément courant
	            System.out.println(courant.getChild("pseudo").getText());
	         }
	      }
	   
}
