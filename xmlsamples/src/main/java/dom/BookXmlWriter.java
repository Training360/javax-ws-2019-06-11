package dom;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public class BookXmlWriter {

    public void writeXml(List<String> title, OutputStream outputStream) {
        var factory = DocumentBuilderFactory.newInstance();
        try {
            var builder = factory.newDocumentBuilder();
            var document = builder.newDocument();
            var catalog = document.createElement("catalog");
            document.appendChild(catalog);

            for (var aTitle: title) {
                var book = document.createElement("book");
                var titleElement = document.createElement("title");
                var titleContent = document.createTextNode(aTitle);
                titleElement.appendChild(titleContent);
                book.appendChild(titleElement);
                catalog.appendChild(book);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(outputStream);
            transformer.transform(source, result);
        } catch (Exception e) {
            throw new RuntimeException("Error write xml", e);
        }
    }

    public static void main(String[] args) {
        var titles = List.of("etwert", "r4tert", "erterte", "erterte");
        var baos = new ByteArrayOutputStream();
        new BookXmlWriter().writeXml(titles, baos);
        var xml = new String(baos.toByteArray());
        System.out.println(xml);
    }
}
