import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientImpl implements HttpClient {
    URL myURL;

    @Override
    public Response get(String url, Map<String, String> headers) {
        Response response = new Response();

        try {
            myURL = new URL(url);
            HttpURLConnection httpUC = (HttpURLConnection) myURL.openConnection();

            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpUC.setRequestProperty(header.getKey(), header.getValue());
            }

            httpUC.connect();

            response.setStatusCode(httpUC.getResponseCode());

            response.setStatusText(httpUC.getResponseMessage());

            Map<String, String> headerFields = new HashMap<>();
            for (Map.Entry<String, List<String>> header : httpUC.getHeaderFields().entrySet()) {
                if (header.getKey() != null) {
                    headerFields.put(header.getKey(), header.getValue().get(0));
                }
            }
            response.setHeaders(headerFields);

            InputStream is = httpUC.getInputStream();

            int payLoadLength = httpUC.getContentLength();
            byte[] payLoad = new byte[payLoadLength];
            for (int i = 0; i < payLoadLength; i++) {
                payLoad[i] = (byte) is.read();
            }
            response.setPayload(new String(payLoad, StandardCharsets.UTF_8));

            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response post(String url, Map<String, String> headers, byte[] payload) {
        Response response = new Response();

        try {
            myURL = new URL(url);
            HttpURLConnection httpUC = (HttpURLConnection) myURL.openConnection();
            httpUC.setRequestMethod("POST");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpUC.setRequestProperty(header.getKey(), header.getValue());
            }

            httpUC.setDoOutput(true);

            httpUC.connect();

            OutputStream os = httpUC.getOutputStream();

            os.write(payload);
            os.flush();

            os.close();

            response.setStatusCode(httpUC.getResponseCode());

            response.setStatusText(httpUC.getResponseMessage());

            Map<String, String> headerFields = new HashMap<>();
            for (Map.Entry<String, List<String>> header : httpUC.getHeaderFields().entrySet()) {
                if (header.getKey() != null) {
                    headerFields.put(header.getKey(), header.getValue().get(0));
                }
            }
            response.setHeaders(headerFields);

            InputStream is = httpUC.getInputStream();

            int payLoadLength = httpUC.getContentLength();
            byte[] payLoad = new byte[payLoadLength];
            for (int i = 0; i < payLoadLength; i++) {
                payLoad[i] = (byte) is.read();
            }
            response.setPayload(new String(payLoad, StandardCharsets.UTF_8));

            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response post(String url, Map<String, String> headers, String payload) {
        Response response = new Response();

        try {
            myURL = new URL(url);
            HttpURLConnection httpUC = (HttpURLConnection) myURL.openConnection();
            httpUC.setRequestMethod("POST");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpUC.setRequestProperty(header.getKey(), header.getValue());
            }

            httpUC.setDoOutput(true);

            httpUC.connect();

            OutputStream os = httpUC.getOutputStream();

            os.write(payload.getBytes(StandardCharsets.UTF_8));
            os.flush();

            os.close();

            response.setStatusCode(httpUC.getResponseCode());

            response.setStatusText(httpUC.getResponseMessage());

            Map<String, String> headerFields = new HashMap<>();
            for (Map.Entry<String, List<String>> header : httpUC.getHeaderFields().entrySet()) {
                if (header.getKey() != null) {
                    headerFields.put(header.getKey(), header.getValue().get(0));
                }
            }
            response.setHeaders(headerFields);

            InputStream is = httpUC.getInputStream();

            int payLoadLength = httpUC.getContentLength();
            byte[] payLoad = new byte[payLoadLength];
            for (int i = 0; i < payLoadLength; i++) {
                payLoad[i] = (byte) is.read();
            }
            response.setPayload(new String(payLoad, StandardCharsets.UTF_8));

            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response put(String url, Map<String, String> headers, byte[] payload) {
        Response response = new Response();

        try {
            myURL = new URL(url);
            HttpURLConnection httpUC = (HttpURLConnection) myURL.openConnection();
            httpUC.setRequestMethod("PUT");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpUC.setRequestProperty(header.getKey(), header.getValue());
            }

            httpUC.setDoOutput(true);

            httpUC.connect();

            OutputStream os = httpUC.getOutputStream();

            os.write(payload);
            os.flush();

            os.close();

            response.setStatusCode(httpUC.getResponseCode());

            response.setStatusText(httpUC.getResponseMessage());

            Map<String, String> headerFields = new HashMap<>();
            for (Map.Entry<String, List<String>> header : httpUC.getHeaderFields().entrySet()) {
                if (header.getKey() != null) {
                    headerFields.put(header.getKey(), header.getValue().get(0));
                }
            }
            response.setHeaders(headerFields);

            InputStream is = httpUC.getInputStream();

            int payLoadLength = httpUC.getContentLength();
            byte[] payLoad = new byte[payLoadLength];
            for (int i = 0; i < payLoadLength; i++) {
                payLoad[i] = (byte) is.read();
            }
            response.setPayload(new String(payLoad, StandardCharsets.UTF_8));

            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response put(String url, Map<String, String> headers, String payload) {
        Response response = new Response();

        try {
            myURL = new URL(url);
            HttpURLConnection httpUC = (HttpURLConnection) myURL.openConnection();
            httpUC.setRequestMethod("PUT");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpUC.setRequestProperty(header.getKey(), header.getValue());
            }

            httpUC.setDoOutput(true);

            httpUC.connect();

            OutputStream os = httpUC.getOutputStream();

            os.write(payload.getBytes(StandardCharsets.UTF_8));
            os.flush();

            os.close();

            response.setStatusCode(httpUC.getResponseCode());

            response.setStatusText(httpUC.getResponseMessage());

            Map<String, String> headerFields = new HashMap<>();
            for (Map.Entry<String, List<String>> header : httpUC.getHeaderFields().entrySet()) {
                if (header.getKey() != null) {
                    headerFields.put(header.getKey(), header.getValue().get(0));
                }
            }
            response.setHeaders(headerFields);

            InputStream is = httpUC.getInputStream();

            int payLoadLength = httpUC.getContentLength();
            byte[] payLoad = new byte[payLoadLength];
            for (int i = 0; i < payLoadLength; i++) {
                payLoad[i] = (byte) is.read();
            }
            response.setPayload(new String(payLoad, StandardCharsets.UTF_8));

            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response delete(String url, Map<String, String> headers, byte[] payload) {
        Response response = new Response();

        try {
            myURL = new URL(url);
            HttpURLConnection httpUC = (HttpURLConnection) myURL.openConnection();
            httpUC.setRequestMethod("DELETE");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpUC.setRequestProperty(header.getKey(), header.getValue());
            }

            httpUC.setDoOutput(true);

            httpUC.connect();

            OutputStream os = httpUC.getOutputStream();

            os.write(payload);
            os.flush();

            os.close();

            response.setStatusCode(httpUC.getResponseCode());

            response.setStatusText(httpUC.getResponseMessage());

            Map<String, String> headerFields = new HashMap<>();
            for (Map.Entry<String, List<String>> header : httpUC.getHeaderFields().entrySet()) {
                if (header.getKey() != null) {
                    headerFields.put(header.getKey(), header.getValue().get(0));
                }
            }
            response.setHeaders(headerFields);

            InputStream is = httpUC.getInputStream();

            int payLoadLength = httpUC.getContentLength();
            byte[] payLoad = new byte[payLoadLength];
            for (int i = 0; i < payLoadLength; i++) {
                payLoad[i] = (byte) is.read();
            }
            response.setPayload(new String(payLoad, StandardCharsets.UTF_8));

            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response delete(String url, Map<String, String> headers, String payload) {
        Response response = new Response();

        try {
            myURL = new URL(url);
            HttpURLConnection httpUC = (HttpURLConnection) myURL.openConnection();
            httpUC.setRequestMethod("DELETE");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpUC.setRequestProperty(header.getKey(), header.getValue());
            }

            httpUC.setDoOutput(true);

            httpUC.connect();

            OutputStream os = httpUC.getOutputStream();

            os.write(payload.getBytes(StandardCharsets.UTF_8));
            os.flush();

            os.close();

            response.setStatusCode(httpUC.getResponseCode());

            response.setStatusText(httpUC.getResponseMessage());

            Map<String, String> headerFields = new HashMap<>();
            for (Map.Entry<String, List<String>> header : httpUC.getHeaderFields().entrySet()) {
                if (header.getKey() != null) {
                    headerFields.put(header.getKey(), header.getValue().get(0));
                }
            }
            response.setHeaders(headerFields);

            InputStream is = httpUC.getInputStream();

            int payLoadLength = httpUC.getContentLength();
            byte[] payLoad = new byte[payLoadLength];
            for (int i = 0; i < payLoadLength; i++) {
                payLoad[i] = (byte) is.read();
            }
            response.setPayload(new String(payLoad, StandardCharsets.UTF_8));

            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
