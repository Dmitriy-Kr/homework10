import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class Response {
    private String statusText;
    private int statusCode;
    private Map<String, String> headers;
    private String payload;

    @Override
    public String toString() {
        StringBuilder responseHeaders = new StringBuilder();
        for (Map.Entry<String,String> header : headers.entrySet()){
            responseHeaders.append(header.getKey())
                    .append(": ")
                    .append(header.getValue())
                    .append(System.lineSeparator());
        }
        return  "SERVER RESPONSE: " + System.lineSeparator() +
                "Status: " + statusText + System.lineSeparator() +
                "Code: " + statusCode + System.lineSeparator() +
                responseHeaders + System.lineSeparator() +
                "PAYLOAD: " + System.lineSeparator() +
                payload;
    }
}
