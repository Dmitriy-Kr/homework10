import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpClientImplSocket implements HttpClient {
    final static String LINESEPARATOP = "\r\n";

    @Override
    public Response get(String url, Map<String, String> headers) {
        StringBuilder getRequest = new StringBuilder("GET");
        Response response = new Response();

        try {
            URL urlClass = new URL(url);

            getRequest.append(" ").append(urlClass.getPath())
                    .append(" ").append("HTTP/1.1").append(LINESEPARATOP)
                    .append("Host: ").append(urlClass.getHost()).append(LINESEPARATOP);

            for (Map.Entry<String, String> header : headers.entrySet()) {
                getRequest.append(header.getKey() + ": " + header.getValue()).append(LINESEPARATOP);
            }

            getRequest.append(LINESEPARATOP);

            Socket socket = new Socket(urlClass.getHost(), 80);

            OutputStream os = socket.getOutputStream();
            os.write(getRequest.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream inputStream = socket.getInputStream();
            response = readServerResponse(inputStream);

            os.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Response post(String url, Map<String, String> headers, byte[] payload) {
        StringBuilder postRequest = new StringBuilder("POST");
        Response response = new Response();

        try {
            URL urlClass = new URL(url);

            postRequest.append(" ").append(urlClass.getPath())
                    .append(" ").append("HTTP/1.1").append(LINESEPARATOP)
                    .append("Host: ").append(urlClass.getHost()).append(LINESEPARATOP);

            for (Map.Entry<String, String> header : headers.entrySet()) {
                postRequest.append(header.getKey() + ": " + header.getValue()).append(LINESEPARATOP);
            }

            postRequest.append(LINESEPARATOP);

            postRequest.append(new String(payload, StandardCharsets.UTF_8));

            Socket socket = new Socket(urlClass.getHost(), 80);

            OutputStream os = socket.getOutputStream();
            os.write(postRequest.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream inputStream = socket.getInputStream();
            response = readServerResponse(inputStream);

            os.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Response post(String url, Map<String, String> headers, String payload) {
        StringBuilder postRequest = new StringBuilder("POST");
        Response response = new Response();

        try {
            URL urlClass = new URL(url);

            postRequest.append(" ").append(urlClass.getPath())
                    .append(" ").append("HTTP/1.1").append(LINESEPARATOP)
                    .append("Host: ").append(urlClass.getHost()).append(LINESEPARATOP);

            for (Map.Entry<String, String> header : headers.entrySet()) {
                postRequest.append(header.getKey() + ": " + header.getValue()).append(LINESEPARATOP);
            }

            postRequest.append(LINESEPARATOP);

            postRequest.append(payload);

            Socket socket = new Socket(urlClass.getHost(), 80);

            OutputStream os = socket.getOutputStream();
            os.write(postRequest.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream inputStream = socket.getInputStream();
            response = readServerResponse(inputStream);

            os.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Response put(String url, Map<String, String> headers, byte[] payload) {
        StringBuilder putRequest = new StringBuilder("PUT");
        Response response = new Response();

        try {
            URL urlClass = new URL(url);

            putRequest.append(" ").append(urlClass.getPath())
                    .append(" ").append("HTTP/1.1").append(LINESEPARATOP)
                    .append("Host: ").append(urlClass.getHost()).append(LINESEPARATOP);

            for (Map.Entry<String, String> header : headers.entrySet()) {
                putRequest.append(header.getKey() + ": " + header.getValue()).append(LINESEPARATOP);
            }

            putRequest.append(LINESEPARATOP);

            putRequest.append(new String(payload, StandardCharsets.UTF_8));

            Socket socket = new Socket(urlClass.getHost(), 80);

            OutputStream os = socket.getOutputStream();
            os.write(putRequest.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream inputStream = socket.getInputStream();
            response = readServerResponse(inputStream);

            os.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Response put(String url, Map<String, String> headers, String payload) {
        StringBuilder putRequest = new StringBuilder("PUT");
        Response response = new Response();

        try {
            URL urlClass = new URL(url);

            putRequest.append(" ").append(urlClass.getPath())
                    .append(" ").append("HTTP/1.1").append(LINESEPARATOP)
                    .append("Host: ").append(urlClass.getHost()).append(LINESEPARATOP);

            for (Map.Entry<String, String> header : headers.entrySet()) {
                putRequest.append(header.getKey() + ": " + header.getValue()).append(LINESEPARATOP);
            }

            putRequest.append(LINESEPARATOP);

            putRequest.append(payload);

            Socket socket = new Socket(urlClass.getHost(), 80);

            OutputStream os = socket.getOutputStream();
            os.write(putRequest.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream inputStream = socket.getInputStream();
            response = readServerResponse(inputStream);

            os.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Response delete(String url, Map<String, String> headers, byte[] payload) {
        StringBuilder deleteRequest = new StringBuilder("DELETE");
        Response response = new Response();

        try {
            URL urlClass = new URL(url);

            deleteRequest.append(" ").append(urlClass.getPath())
                    .append(" ").append("HTTP/1.1").append(LINESEPARATOP)
                    .append("Host: ").append(urlClass.getHost()).append(LINESEPARATOP);

            for (Map.Entry<String, String> header : headers.entrySet()) {
                deleteRequest.append(header.getKey() + ": " + header.getValue()).append(LINESEPARATOP);
            }

            deleteRequest.append(LINESEPARATOP);

            deleteRequest.append(new String(payload, StandardCharsets.UTF_8));

            Socket socket = new Socket(urlClass.getHost(), 80);

            OutputStream os = socket.getOutputStream();
            os.write(deleteRequest.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream inputStream = socket.getInputStream();
            response = readServerResponse(inputStream);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Response delete(String url, Map<String, String> headers, String payload) {
        StringBuilder deleteRequest = new StringBuilder("DELETE");
        Response response = new Response();

        try {
            URL urlClass = new URL(url);

            deleteRequest.append(" ").append(urlClass.getPath())
                    .append(" ").append("HTTP/1.1").append(LINESEPARATOP)
                    .append("Host: ").append(urlClass.getHost()).append(LINESEPARATOP);

            for (Map.Entry<String, String> header : headers.entrySet()) {
                deleteRequest.append(header.getKey() + ": " + header.getValue()).append(LINESEPARATOP);
            }

            deleteRequest.append(LINESEPARATOP);

            deleteRequest.append(payload);

            Socket socket = new Socket(urlClass.getHost(), 80);

            OutputStream os = socket.getOutputStream();
            os.write(deleteRequest.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream inputStream = socket.getInputStream();
            response = readServerResponse(inputStream);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    private Response readServerResponse (InputStream is){
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String[] startLineArray = null;
        Map<String, String> responseHeader = new LinkedHashMap<>();
        byte[] payLoad = null;

        try {
            String startLine = br.readLine();

            if (!startLine.isEmpty()) {
                startLineArray = startLine.split(" ");
            }

            String headerLine;

            while (!(headerLine = br.readLine()).isEmpty()) {
                String[] array = headerLine.split(":", 2);
                responseHeader.put(array[0], array[1].trim());
            }

            int payLoadLength = Integer.parseInt(responseHeader.get("Content-Length"));
            payLoad = new byte[payLoadLength];
            for (int i = 0; i < payLoadLength; i++) {
                payLoad[i] = (byte) br.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Response().setStatusCode(Integer.parseInt(startLineArray[1]))
                .setStatusText(startLineArray[2])
                .setHeaders(responseHeader)
                .setPayload(new String(payLoad, StandardCharsets.UTF_8));
    }
}
