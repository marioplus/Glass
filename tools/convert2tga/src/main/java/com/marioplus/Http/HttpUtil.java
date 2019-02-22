package com.marioplus.Http;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;

public class HttpUtil {


    private static <T> Optional<T> execute(RequestBuilder requestBuilder, BaseHandler<T> handler) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            T data = httpClient.execute(requestBuilder.build(), handler);
            return Optional.ofNullable(data);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static Optional<String> doGet(String url) {
        return execute(RequestBuilder.get(url), new StringHandler());
    }

    public static Optional<String> doPost(String url, String jsonStr) {
        StringEntity entity = new StringEntity(jsonStr, "UTF-8");
        return execute(RequestBuilder.post(url).setEntity(entity), new StringHandler());
    }

    public static <T> Optional<String> doPost(String url, T t) {
        return doPost(url, JSON.toJSONString(t));
    }
}

abstract class BaseHandler<T> implements ResponseHandler<T>, Function<HttpResponse, T> {
    @Override
    public T handleResponse(HttpResponse response) throws ClientProtocolException {
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            return apply(response);
        } else {

            throw new ClientProtocolException("意外的相应状态： " + status);
        }
    }
}

class StringHandler extends BaseHandler<String> {

    @Override
    public String apply(HttpResponse response) {
        try {
            String data = EntityUtils.toString(response.getEntity());
            return JSON.parseObject(data, String.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
