import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Main {
    public static String GET_URL = "https://jsonplaceholder.typicode.com/posts/1";
    public static String POST_URL = "https://jsonplaceholder.typicode.com/posts";
    public static String PUT_URL = "https://jsonplaceholder.typicode.com/posts/1";
    public static String DELETE_URL = "https://jsonplaceholder.typicode.com/posts/1";

    public static void main(String[] args) {
        byte[] postPayLoad = new byte[]{};
        byte[] putPayLoad = new byte[]{};

        Response response;

        Message postMessage = new Message();
        postMessage.setId(null);
        postMessage.setUserId(1);
        postMessage.setTitle("My post request title");
        postMessage.setBody("My post request body");

        Message putMessage = new Message();
        putMessage.setId(49);
        putMessage.setUserId(49);
        putMessage.setTitle("My put request title");
        putMessage.setBody("My put request body");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            postPayLoad = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(postMessage);
            putPayLoad = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(putMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpClient httpClient = new HttpClientImpl();

        System.out.println("--------------------GET  START-------------------------------");
        response = httpClient.get(GET_URL, Map.of("Connection", "close"));
        System.out.println(response);
        System.out.println("--------------------GET  END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------POST  START-------------------------------");
        response = httpClient.post(POST_URL,
                Map.of("Connection", "close", "Content-Type",
                "application/json; charset=utf-8"),
                postPayLoad);
        System.out.println(response);
        System.out.println("--------------------POST  END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------POST String payload  START-------------------------------");
        response = httpClient.post(POST_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8"),
                new String(postPayLoad, StandardCharsets.UTF_8));
        System.out.println(response);
        System.out.println("--------------------POST String payload  END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------PUT  START-------------------------------");
        response = httpClient.put(PUT_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8"),
                putPayLoad);
        System.out.println(response);
        System.out.println("--------------------PUT  END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------PUT String payload  START-------------------------------");
        response = httpClient.put(PUT_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8"),
                new String(putPayLoad, StandardCharsets.UTF_8));
        System.out.println(response);
        System.out.println("--------------------PUT String payload  END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------DELETE  START-------------------------------");
        response = httpClient.delete(DELETE_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8"),
                new byte[]{});
        System.out.println(response);
        System.out.println("--------------------DELETE  END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------DELETE String payload  START-------------------------------");
        response = httpClient.delete(DELETE_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8"),
                "");
        System.out.println(response);
        System.out.println("--------------------DELETE String payload  END-------------------------------" + System.lineSeparator());

//--------------------------HttpClientImplSocket----------------------------------------------------------------

        HttpClientImplSocket httpClientImplSocket = new HttpClientImplSocket();

        System.out.println("--------------------GET socket START-------------------------------");
        response = httpClientImplSocket.get(GET_URL, Map.of("Connection", "close"));
        System.out.println(response);
        System.out.println("--------------------GET socket END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------POST socket START-------------------------------");
        response = httpClientImplSocket.post(POST_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8",
                        "Content-length", Integer.toString(postPayLoad.length)),
                postPayLoad);
        System.out.println(response);
        System.out.println("--------------------POST socket END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------POST socket String payload  START-------------------------------");
        response = httpClientImplSocket.post(POST_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8",
                        "Content-length", Integer.toString(postPayLoad.length)),
                new String(postPayLoad, StandardCharsets.UTF_8));
        System.out.println(response);
        System.out.println("--------------------POST socket String payload  END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------PUT socket START-------------------------------");
        response = httpClientImplSocket.put(PUT_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8",
                        "Content-length", Integer.toString(putPayLoad.length)),
                putPayLoad);
        System.out.println(response);
        System.out.println("--------------------PUT socket END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------PUT socket String payload  START-------------------------------");
        String putPayLoadStr = new String(putPayLoad, StandardCharsets.UTF_8);
        response = httpClientImplSocket.put(PUT_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8",
                        "Content-length", Integer.toString(putPayLoadStr.length())),
                putPayLoadStr);
        System.out.println(response);
        System.out.println("--------------------PUT socket String payload  END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------DELETE socket START-------------------------------");
        byte[] deletePayLoad = new byte[]{};
        response = httpClientImplSocket.delete(DELETE_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8",
                        "Content-length", Integer.toString(deletePayLoad.length)),
                deletePayLoad);
        System.out.println(response);
        System.out.println("--------------------DELETE socket END-------------------------------" + System.lineSeparator());

        System.out.println("--------------------DELETE socket String payload  START-------------------------------");
        String deletePayLoadStr = new String(deletePayLoad, StandardCharsets.UTF_8);
        response = httpClientImplSocket.delete(DELETE_URL,
                Map.of("Connection", "close",
                        "Content-Type", "application/json; charset=utf-8",
                        "Content-length", Integer.toString(deletePayLoadStr.length())),
                deletePayLoadStr);
        System.out.println(response);
        System.out.println("--------------------DELETE socket String payload  END-------------------------------" + System.lineSeparator());
    }
}
