package com.marioplus;

import com.alibaba.fastjson.JSON;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Optional;

public class HttpUtils {

    private static final int GET = 1;
    private static final int POST = 2;

    private HttpEntity requestEntiry;
    private String url;

    public static HttpUtils create(String url, HttpEntity requestEntiry) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.url = url;
        httpUtils.requestEntiry = requestEntiry;
        return httpUtils;
    }

    private <T> Optional<T> execute(GetDataHandler<T> handler, int method) {
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
            RequestBuilder requestBuilder;

            if (method == GET) {
                requestBuilder = RequestBuilder.get(url);
            } else {
                requestBuilder = RequestBuilder.post(url);
            }

            if (requestEntiry != null) {
                requestBuilder = requestBuilder.setEntity(requestEntiry);
            }

            return Optional.ofNullable(httpclient.execute(requestBuilder.build(), handler));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private <T> Optional<T> executeGetData(@NotNull T t, int method) {
        return execute(new GetDataHandler<T>() {
            @Override
            public T apply(HttpResponse httpResponse) {
                try {
                    String jsonStr = EntityUtils.toString(httpResponse.getEntity());
                    return JSON.parseObject(jsonStr, (Type) t.getClass());
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }, method);
    }

    public <T> Optional<T> doGetData(@NotNull T t) {
        return executeGetData(t, GET);
    }


    public Boolean doGetState(GetStateHandle handler) {
        return execute(handler, GET).orElse(false);
    }

    public <T> Optional<T> doPostData(@NotNull T t) {
        return executeGetData(t, POST);
    }

    public Boolean doPostState(GetStateHandle handler) {
        return execute(handler, POST).orElse(false);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public Optional<File> getDownloadData(String path, String name) {
        return execute(new GetDataHandler<File>() {
            @Override
            public File apply(HttpResponse httpResponse) {
                try (InputStream source = httpResponse.getEntity().getContent()) {
                    try (OutputStream os = new FileOutputStream(path + name)) {
                        // 1K的数据缓冲
                        byte[] bs = new byte[1024];
                        // 读取到的数据长度
                        int len;
                        // 输出的文件流
                        File file = new File(path);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        // 开始读取
                        while ((len = source.read(bs)) != -1) {
                            os.write(bs, 0, len);
                        }
                        return file;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }, GET);
    }

    public boolean getDownloadResult(String path, String name) {
        return getDownloadData(path, name).isPresent();
    }

}
