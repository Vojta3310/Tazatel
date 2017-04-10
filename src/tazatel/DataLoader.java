/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel;

import tazatel.dataStructure.OtazkyData;
import tazatel.dataStructure.OtazkaData;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Ondřej Bleha
 */
public class DataLoader {
    private final InputStream is;
    
    public DataLoader(String file) throws IOException{
        this.is = getClass().getResourceAsStream(file);
    }
    
    public OtazkyData read() throws ParserConfigurationException, SAXException, IOException{
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser parser = spf.newSAXParser();
        Handler handler = new Handler();
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(is));
        return handler.getData();
    }
    
    static class Handler extends DefaultHandler {

        OtazkyData data;              
        boolean boo_ulohy = false;
        boolean boo_predmet = false;
        
        public OtazkyData getData() {
            return data;
        }
        
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {         
            
            if (qName.equals("ulohy")) {
                boo_ulohy = true;
                data = new OtazkyData();
            }
            
            if (qName.equals("predmet") && boo_ulohy) {
                boo_predmet = true;
                for (int i = 0; i < attributes.getLength(); i++) {
                    if (attributes.getLocalName(i).equals("nazev")) {
                        data.addPredmet(attributes.getValue(i));
                    }
                }
            }
            
            if (qName.equals("uloha") && boo_ulohy && boo_predmet) {
                String id = "";
                String zadani = "";
                String dokument = "";
                int pouzito = 0;
                for (int i = 0; i < attributes.getLength(); i++) {
                    switch (attributes.getLocalName(i)) {
                        case "id":
                            id = attributes.getValue(i);
                            break;
                        case "zadani":
                            zadani = attributes.getValue(i);
                            break;
                        case "dokument":
                            dokument = attributes.getValue(i);
                            break;
                        case "pouzito":
                            pouzito = Integer.valueOf(attributes.getValue(i));
                            break;
                        default:
                            break;
                    }
                }
                data.addOtazka(new OtazkaData(id, zadani, dokument, pouzito));
            }
            
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            switch (qName) {
                case "ulohy":
                    boo_ulohy = false;
                    break;
                case "predmet":
                    boo_predmet = false;
                    break;
            }
        }

        @Override
        public void setDocumentLocator(Locator locator) {
        }

        @Override
        public void startDocument() throws SAXException {
            if (boo_predmet || boo_ulohy) {
                throw new VerifyError();
            }
        }

        @Override
        public void endDocument() throws SAXException {
            if (boo_predmet || boo_ulohy) {
                throw new VerifyError();
            }
        }
    }
    
}
