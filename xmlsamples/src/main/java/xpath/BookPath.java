package xpath;

import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

public class BookPath {

    public void getTitle(int i, InputStream inputStream) {
        var p = "/catalog/book[" + i + "]/title";
        var factory = XPathFactory.newInstance();
        var xpath = factory.newXPath();
        try {
            var expr = xpath.compile(p);
            var title = (Element) expr.evaluate(new InputSource(inputStream), XPathConstants.NODE);
            System.out.println(title.getTextContent());
        }
        catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static void main(String[] args) {
        new BookPath().getTitle(3, BookPath.class.getResourceAsStream("/books.xml"));
    }
}
