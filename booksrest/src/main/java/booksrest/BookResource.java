package booksrest;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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

    @POST
    public void addBook(Book book) {
        books.add(book);
    }

    @POST
    @Path("{isbn10}")
    public void updateBook(@PathParam("isbn10") String isbn10, Book book) {
        var found = books.stream().filter(b -> b.getIsbn10().equals(isbn10)).findAny().get();
        found.setAuthor(book.getAuthor());
        found.setTitle(book.getTitle());
        found.setYear(book.getYear());
    }

    @DELETE
    @Path("{isbn10}")
    public void deleteBook(@PathParam("isbn10") String isbn10) {
        var found = books.stream().filter(b -> b.getIsbn10().equals(isbn10)).findAny().get();
        books.remove(found);
    }

    @GET
    @Path("{isbn10}")
    public Response findBookByIsbn10(@PathParam("isbn10") String isbn10) {
        var book = books.stream().filter(b -> b.getIsbn10().equals(isbn10)).findAny();
        if (book.isPresent()) {
            return Response.ok(book.get()).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public static void main(String[] args) {
        var config = new ResourceConfig().packages("booksrest");
        GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8082/"),
                config);
    }
}
