package stax;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class BookStaxWriterTest {

    @Test
    public void testWriteXml() {
        var titles = List.of("Micimacko", "22-es csapdaja", "Java es XML");
        var baos = new ByteArrayOutputStream();
        new BookStaxWriter().writeXml(titles, baos);
        var xml = new String(baos.toByteArray());
        System.out.println(xml);
    }
}
