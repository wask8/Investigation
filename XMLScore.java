package new_investigation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLScore {
	File f;
	String url;
	
	
	public XMLScore() {
		super();
		this.f = new File("donnees.xml");
		this.url = f.getAbsolutePath();
		System.out.println(url);
	}
	
	public List<ObjetScore> getListScoreXML(){
		 final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 List<ObjetScore> list = new ArrayList<ObjetScore>();
			try {
				// crÃ©er un parseur
				final DocumentBuilder builder = factory.newDocumentBuilder();

				// crÃ©ation d'un document Ã  partir d'un fichier
				final Document document = builder.parse(url);

				// obtenir la racine du fichier
				final Element racine = document.getDocumentElement();
				
				// obtenir les noeuds du fichier
				final NodeList racineNoeuds = racine.getChildNodes();

				final int nbRacineNoeuds = racineNoeuds.getLength();
			
				for (int i = 0; i < nbRacineNoeuds; i++) {
					
					if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
						final Element element = (Element) racineNoeuds.item(i);

						Element nomPseudo = (Element) element.getElementsByTagName(
								"pseudo").item(0);
						Element nbPoints = (Element) element.getElementsByTagName("score").item(0);
						list.add(new ObjetScore(nomPseudo.getTextContent(),nbPoints.getTextContent()));
					}
				}
				Collections.sort(list);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
			
			
		
		
	}
	
	
//	public List<ObjetScore> getListCartesXML(){
//		 final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		 List<ObjetScore> list = new ArrayList<ObjetScore>();
//			try {
//				// crÃ©er un parseur
//				final DocumentBuilder builder = factory.newDocumentBuilder();
//
//				// crÃ©ation d'un document Ã  partir d'un fichier
//				final Document document = builder.parse(url);
//
//				// obtenir la racine du fichier
//				final Element racine = document.getDocumentElement();
//				
//				// obtenir les noeuds du fichier
//				final NodeList racineNoeuds = racine.getChildNodes();
//
//				final int nbRacineNoeuds = racineNoeuds.getLength();
//			
//				for (int i = 0; i < nbRacineNoeuds; i++) {
//					
//					if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
//						final Element element = (Element) racineNoeuds.item(i);
//
//						Element nomPseudo = (Element) element.getElementsByTagName(
//								"pseudo").item(0);
//						Element nbPoints = (Element) element.getElementsByTagName("score").item(0);
//						list.add(new ObjetScore(nomPseudo.getTextContent(),nbPoints.getTextContent()));
//					}
//				}
//				Collections.sort(list);
//				
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return list;
//			
//			
//		
//		
//	}
	
	
	
	
	
    
	public void ecrirescoreXML(String pseudo, int score) {

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            final DocumentBuilder builder = factory.newDocumentBuilder();

	    final Document document= builder.parse(url);
	    
	    final Element racine = document.getDocumentElement();
	    
	    String a = ""+score;
	    
		final Element elem1 = document.createElement("joueur");
		racine.appendChild(elem1);	
		
		final Element nom = document.createElement("pseudo");
		elem1.appendChild(nom);
		nom.appendChild(document.createTextNode(pseudo));
		
		final Element scoreA = document.createElement("score");
		elem1.appendChild(scoreA);
		scoreA.appendChild(document.createTextNode(a));
	
		
		racine.appendChild(elem1);
		
		
		 final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		 final Transformer transformer = transformerFactory.newTransformer();
		 final DOMSource source = new DOMSource(document);
		 final StreamResult sortie = new StreamResult(url);
		 transformer.transform(source, sortie);
	    
        }
        catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (final SAXException e) {
            e.printStackTrace();
        }
        catch (final IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
    }
	

	
	
}
