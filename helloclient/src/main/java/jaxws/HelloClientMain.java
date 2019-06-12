package jaxws;

import com.learnwebservices.services.hello.HelloEndpoint;
import com.learnwebservices.services.hello.HelloEndpointService;
import com.learnwebservices.services.hello.HelloRequest;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

public class HelloClientMain {

    public static void main(String[] args) {
        var service = new HelloEndpointService();
        var port = service.getHelloEndpointPort();

        var bp = (BindingProvider)port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8088/hello");


        var request = new HelloRequest();
        request.setName("Oktato");

        var response = port.sayHello(request);

        System.out.println(response.getMessage());
    }
}
