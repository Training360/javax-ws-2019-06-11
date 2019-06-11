package dom;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class BookXmlReader {

    public void readTitles(InputStream inputStream) {
        var factory = DocumentBuilderFactory
                .newInstance();
        try {
            var builder = factory.newDocumentBuilder();
            var document = builder.parse(inputStream);
            var titles = document.getElementsByTagName("title");
            for (var i = 0; i < titles.getLength(); i++) {
                var title = (Element) titles.item(i);
                var bookTitle = title.getFirstChild().getNodeValue();
                System.out.println(bookTitle);
            }
        }
        catch (ParserConfigurationException |
                IOException |
                SAXException e) {
            throw new RuntimeException("Error reading XML", e);
        }
    }

    public static void main(String[] args) {
        new BookXmlReader().readTitles(
                BookXmlReader.class.getResourceAsStream("/books.xml")
        );
    }
}
