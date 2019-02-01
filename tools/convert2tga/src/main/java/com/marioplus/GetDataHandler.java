package com.marioplus;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;
import java.util.function.Function;

public abstract class GetDataHandler<T> implements ResponseHandler<T>, Function<HttpResponse, T> {
    @Override
    public T handleResponse(HttpResponse httpResponse) throws IOException {
        int status = httpResponse.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            return apply(httpResponse);
        } else {
            throw new ClientProtocolException("意外的相应状态： " + status);
        }
    }
}
