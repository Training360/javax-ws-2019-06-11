package booksrest;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.net.URI;
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

    @GET
    @Path("{isbn10}")
    public Book findBookByIsbn10(@PathParam("isbn10") String isbn10) {
        return books.stream().filter(b -> b.getIsbn10().equals(isbn10)).findAny().get();
    }

    public static void main(String[] args) {
        var config = new ResourceConfig().packages("booksrest");
        GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8082/"),
                config);
    }
}
