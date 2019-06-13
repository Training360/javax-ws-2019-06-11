package booksrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("books")
public class BookResource {

    private static final List<Book> books =
            new ArrayList<>(List.of(
                    new Book("iro1", "cim1", 2019, "xxx1"),
                    new Book("iro2", "cim2", 2019, "xxx2"),
                    new Book("iro3", "cim3", 2019, "xxx3"),
                    new Book("iro4", "cim4", 2019, "xxx4")
            ));

    @GET
    public List<Book> listBooks() {
        return books;
    }
}
