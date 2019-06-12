package xsd;

import dom.BookXmlReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;

public class BookValidator {

    public void validateXml(InputStream inputStream) {
        var factory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            var schema = factory.newSchema(
                    new StreamSource(
                            BookValidator.class.getResourceAsStream("/books.xsd")));
            var validator = schema.newValidator();
            validator.validate(new StreamSource(inputStream));
        }
        catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static void main(String[] args) {
        new BookValidator().validateXml(
                BookValidator.class.getResourceAsStream("/books.xml")
        );
    }
}
