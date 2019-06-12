package stax;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.xmlunit.matchers.EvaluateXPathMatcher.hasXPath;

public class BookStaxWriterTest {

    @Test
    public void testWriteXml() {
        var titles = List.of("Micimacko", "22-es csapdaja", "Java es XML");
        var baos = new ByteArrayOutputStream();
        new BookStaxWriter().writeXml(titles, baos);
        var xml = new String(baos.toByteArray());
        System.out.println(xml);

        assertThat(xml, hasXPath("/catalog/book[3]/title",
                equalTo("Java es XML")));
    }
}
