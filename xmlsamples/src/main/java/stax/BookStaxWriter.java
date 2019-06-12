package stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.OutputStream;
import java.util.List;

public class BookStaxWriter {

    public void writeXml(List<String> titles, OutputStream outputStream) {
        var factory = XMLOutputFactory.newFactory();
        try {
            var writer = factory.createXMLStreamWriter(outputStream);

            writer.writeStartDocument();
            writer.writeStartElement("catalog");
            for (String title: titles) {
                writer.writeStartElement("book");
                writer.writeStartElement("title");
                writer.writeCharacters(title);
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        }
        catch (XMLStreamException e) {
            throw new RuntimeException("Error", e);
        }
    }
}
