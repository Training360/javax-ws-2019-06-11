package bookservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(targetNamespace = "http://training360.com/books")
public class BookServiceEndpoint {

    @WebMethod
    @WebResult(name = "book")
    @XmlElementWrapper(name = "books")
    public List<Book> listBooks() {
        return List.of(
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345"),
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345"),
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345"),
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345"),
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345")
        );
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/", new BookServiceEndpoint());
    }
}
