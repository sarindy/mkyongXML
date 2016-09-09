package mkyongXML;

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

public class Apps {

	public static void main(String[] args) {

		try {
			File fXmlFile = new File("mkyong.xml");
			///mkyongXML/src/mkyong.xml
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc;

			doc = dBuilder.parse(fXmlFile);
			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Doc");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//System.out.println("BizDate : "+ eElement.getAttribute("id"));
					//System.out.println("BizTime : "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
					
					
						
					System.out.println("BizDate : "+ eElement.getElementsByTagName("BizDate").item(0).getTextContent());
					System.out.println("BizDate : "+ eElement.getElementsByTagName("BizTime").item(0).getTextContent());
					System.out.println("Settlement Balanc USD : " + eElement.getElementsByTagName("settleUSD").item(0).getTextContent());
					
					
				}
			}
			
			System.out.println("-----------------------");
			
			nList = doc.getElementsByTagName("Brnch");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					
					System.out.println("Nb : "+ eElement.getElementsByTagName("Nb").item(0).getTextContent());
					System.out.println("Acc : "+ eElement.getElementsByTagName("Acc").item(0).getTextContent());
					System.out.println("Balance USD : " + eElement.getElementsByTagName("Bal").item(0).getTextContent());
					
					
				}
			}
			
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
