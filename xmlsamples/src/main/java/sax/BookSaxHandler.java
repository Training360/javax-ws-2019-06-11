package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookSaxHandler extends DefaultHandler {

    private String tagInProcess;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Elertem a kovetkezo taghez: " + qName);
        tagInProcess = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Elertem a lezaro taghez: " + qName);
        tagInProcess = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tagInProcess.equals("title")) {
            System.out.println(new String(ch, start, length));
        }
    }
}
