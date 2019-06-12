package xslt;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BooksTransform {

    public void transformToHtml(InputStream inputStream,
                                OutputStream outputStream) {
        var factory = TransformerFactory.newInstance();
        try {
            var transformer = factory.newTransformer(new StreamSource(BooksTransform.class
                    .getResourceAsStream("/books.xslt")));
            transformer.transform(new StreamSource(inputStream),
                    new StreamResult(outputStream));
        }
        catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static void main(String[] args) {
        var outputStream = new ByteArrayOutputStream();
        new BooksTransform().transformToHtml(BooksTransform.class
                .getResourceAsStream("/books.xml"),
                outputStream);
        System.out.println(new String(outputStream.toByteArray()));
    }
}
