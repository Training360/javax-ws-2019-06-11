package bookservice;

import javax.jws.WebService;
import java.util.List;

@WebService
public class BookServiceEndpoint {

    public List<Book> listBooks() {
        return List.of(
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345"),
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345"),
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345"),
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345"),
                new Book("Joseph Heller", "22-es csapdája", 1970, "XY12345")
        );
    }
}
