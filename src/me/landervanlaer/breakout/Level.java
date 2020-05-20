package me.landervanlaer.breakout;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


//https://www.youtube.com/watch?v=HfGWVy-eMRc
//https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm

public class Level {

    public static void main(String[] args) {
        Level level = new Level();
        level.getblocks(1);
    }

    private ArrayList<Block> getblocks(int lvl) {
        try {
            File file = new File("src/me/landervanlaer/breakout/level" + lvl + ".xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println(doc.getElementsByTagName("Block").item(0).getChildNodes());


        } catch(ParserConfigurationException | IOException | SAXException e) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("ERROR OCCURED");
            System.out.println("--------------------------------------------------------------\n");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
