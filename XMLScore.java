package test1;

import java.io.File;
import java.io.IOException;

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
	
    
	public XMLScore(String pseudo, int score) {
		
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            	
        try {
            final DocumentBuilder builder = factory.newDocumentBuilder();

	    final Document document= builder.parse(new File("repertoireXMLTest.xml"));
	    
	    final Element racine = document.getDocumentElement();
	    
	    String a = ""+score;
	    
		final Element elem1 = document.createElement("joueur");
		racine.appendChild(elem1);	
		System.out.println("1");
		
		final Element nom = document.createElement("pseudo");
		elem1.appendChild(nom);
		nom.appendChild(document.createTextNode(pseudo));
		System.out.println("2");
		
		final Element scoreA = document.createElement("score");
		elem1.appendChild(scoreA);
		scoreA.appendChild(document.createTextNode(a));
		
		System.out.println("v1");
		
		racine.appendChild(elem1);
		System.out.println("v2");
		
		 final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		 final Transformer transformer = transformerFactory.newTransformer();
		 final DOMSource source = new DOMSource(document);
		 final StreamResult sortie = new StreamResult(new File("repertoireXMLTest.xml"));
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
