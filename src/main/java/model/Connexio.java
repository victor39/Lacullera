package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Connexio {

	private Connection connexio;
	
	/*public Connexio() {
		try {
			
			this.connexio = DriverManager.getConnection("jdbc:mysql://ffames.cat/projecte_amv","fora","Dam2020!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}*/
	
	public Connexio(String host, String bd, int port, String usuari, String contrasenya) {
		try {
			this.connexio = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+bd,usuari,contrasenya);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connexio() {
		 try
	        {
	     	    SAXBuilder sax = new SAXBuilder();
	            Document doc = (Document) sax.build("config.xml");
	            Element arrel = (Element) doc.getRootElement();
	            
	            List<Element> llista= arrel.getChildren("bbdd"); 
	                for (Element target : llista) {
			            String host = target.getChildText("host");
			            String bd = target.getChildText("bd");
			            String port = target.getChildText("port");
			            String usuari = target.getChildText("usuari");
			            String contraseña = target.getChildText("contraseña");
			            
						this.connexio = DriverManager.getConnection("jdbc:mysql://"+ host  + ":" + Integer.parseInt(port) + "/" + bd , usuari , contraseña);
						System.out.println("Entra?");
	                }
				    		
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}
	
	public Connection getConnexio() {
		return connexio;
	}
}
