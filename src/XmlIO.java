
//Use DOM Parser 

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;  // for transform and write into xml file
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

/**
 * 
 * Class to read and write a XML file
 *
 */
public class XmlIO {
	
	private String filename;
	
	
	public String getFilename()
	{
		return(filename);
	}
	
	
	public void setFilename(String file)
	{
		filename = file;
	}
	
	
	/**
	 * Read a XML file
	 */
	public void readFile()
	{
		String value;
		try
		{
			File file = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse(file);
			
			//Puts all Text nodes in the full depth of the sub-tree underneath this Node
			doc.getDocumentElement().normalize();
			String userInfoElement = doc.getDocumentElement().getNodeName();
			
			// get USER nodelist
			NodeList userList = doc.getElementsByTagName("USER");
			for (int i=0;i<userList.getLength();i++)
			{
				Node userNode = userList.item(i);
				if (userNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element userElement = (Element)userNode;
					value = getTagValue("LASTNAME",userElement);
					System.out.println("LASTNAME = " + value);
					value = getTagValue("FIRSTNAME",userElement);
					System.out.println("FIRSTNAME = " + value);
					value = getTagValue("TITLE",userElement);
					System.out.println("TITLE = " + value);
				}
			} // end for
		}
		catch(Exception ex)
		{
			System.out.println("Error: readFile " + ex.getMessage());
		}
		
	}

	
	/**
	 * Get value from a node element
	 * @param sTag
	 * @param element
	 * @return
	 */
	private static String getTagValue(String sTag, Element element)
	{
		NodeList nList = element.getElementsByTagName(sTag).item(0).getChildNodes();
		
		Node nValue = (Node)nList.item(0);
		return(nValue.getNodeValue());		
	}
	
	
	/**
	 * Write to an XML file
	 */
	public void writeFile()
	{
		File file = new File(filename);
		
		if(file.exists())
		{
			file.delete();
		}
		
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			// root element
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("USERINFO");
			doc.appendChild(rootElement);
			rootElement.setAttribute("version", "1");
			
			// add child element named USER
			Element user = doc.createElement("USER");
			rootElement.appendChild(user);
			
			// add child elements for USER 
			Element lastname = doc.createElement("LASTNAME");
			lastname.appendChild(doc.createTextNode("Lam"));
			user.appendChild(lastname);
			
			Element firstname = doc.createElement("FIRSTNAME");
			firstname.appendChild(doc.createTextNode("Stanley"));
			user.appendChild(firstname);
			
			Element title = doc.createElement("TITLE");
			title.appendChild(doc.createTextNode("Software Engineer"));
			user.appendChild(title);
			
			// write content into an XML file
			TransformerFactory trFactory = TransformerFactory.newInstance();
			Transformer tr = trFactory.newTransformer();
			tr.setParameter(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			
			tr.transform(source, result);
		}
		catch(Exception ex)
		{
			System.out.println("Error: writeFile() " + ex.getMessage());
		} // end try-catch
		
	} // end writeFile

} // end class XmlIO

