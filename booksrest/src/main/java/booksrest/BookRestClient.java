package booksrest;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class BookRestClient {

    public static void main(String[] args) {
        var books =
                ClientBuilder.newClient()
                .target("http://localhost:8082/books")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Book>>(){});

        for (var book: books) {
            System.out.println(book.getTitle());
        }
    }
}
