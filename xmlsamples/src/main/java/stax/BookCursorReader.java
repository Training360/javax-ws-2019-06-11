package stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class BookCursorReader {

    public void readXml(InputStream inputStream) {
        var factory = XMLInputFactory.newFactory();
        try {
            var reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                if (reader.getEventType() == XMLStreamConstants.START_ELEMENT &&
                    reader.getName().getLocalPart().equals("title")) {
                    System.out.println(reader.getElementText());
                }
                reader.next();
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }
}
