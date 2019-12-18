package example.xmlDom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParse {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        //创建dom文档的机器
        DocumentBuilder db=dbf.newDocumentBuilder();
       Document d=db.parse("student.xml");
        NodeList nl=d.getElementsByTagName("student");

        Node n=nl.item(0);
        System.out.println(n.getLastChild().getFirstChild().getNodeValue());
    }
}
