package stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.StartElement;
import java.io.InputStream;

public class BookIteratorReader {

    public void readXml(InputStream inputStream) {
        var factory = XMLInputFactory.newFactory();
        try {
            var reader = factory.createXMLEventReader(inputStream);
            while (reader.hasNext()) {
                var event = reader.nextEvent();
                if (event instanceof StartElement &&
                        ((StartElement)event).getName().getLocalPart().equals("title")) {
                    System.out.println(reader.getElementText());
                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }
}
