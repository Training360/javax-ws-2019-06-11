package sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

public class BookSaxReader {

    public void readXml(InputStream inputStream) {
        var factory = SAXParserFactory.newInstance();
        try {
            var saxParser = factory.newSAXParser();
            var handler = new BookSaxHandler();
            saxParser.parse(inputStream, handler);
        }
        catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }
}
