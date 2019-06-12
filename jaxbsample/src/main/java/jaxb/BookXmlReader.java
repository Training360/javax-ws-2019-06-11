package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;

public class BookXmlReader {

    public Catalog readXml(InputStream inputStream) {
        try {
            var context = JAXBContext.newInstance(Catalog.class, Book.class);
            var unmarshaller = context.createUnmarshaller();
            return (Catalog) unmarshaller.unmarshal(inputStream);
        }
        catch (JAXBException e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static void main(String[] args) {
        var catalog = new BookXmlReader().readXml(
                BookXmlReader.class.getResourceAsStream("/books.xml"));
        for (var book: catalog.getBooks()) {
            System.out.println(book.getTitle());
        }
    }
}
