package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class BookXmlWriter {

    public void writeXml(Book book, OutputStream outputStream) {
        try {
            var context = JAXBContext.newInstance(Book.class);
            var marshaller = context.createMarshaller();
            marshaller.marshal(book, outputStream);
        }
        catch (JAXBException e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static void main(String[] args) {
        var book = new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345");
        var outputStream = new ByteArrayOutputStream();
        new BookXmlWriter().writeXml(book, outputStream);
        System.out.println(new String(outputStream.toByteArray()));
    }
}
