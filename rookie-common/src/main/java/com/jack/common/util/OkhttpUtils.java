package com.jack.common.util;

import com.google.common.collect.Maps;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created By Jack on 2019/12/4
 *
 * @author Jack
 * @date 2019/12/4 20:17
 * @Description:
 * 网络请求工具类
 * https://www.jianshu.com/p/da4a806e599b
 * https://www.jianshu.com/p/c1655f5c0fc0
 *
 * OkHttpClient可以增加过滤器
 */
public class OkhttpUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(OkhttpUtils.class);
    public static OkHttpClient okHttpClient = new OkHttpClient();
    private OkhttpUtils() {
    }

    /**
     * 异步get请求
     * @param url
     * @return
     */
    public static<T> String asynGet(String url/*, Supplier<T> supplier*/){
        final Request request = new Request.Builder()
                .url(url)
                //默认就是GET请求，可以不写
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        final StringBuilder result = new StringBuilder() ;
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result.append(response.body().toString());
                //supplier.get();
                LOGGER.info("onResponse data:[{}]: ", response.body().string());
            }
            @Override
            public void onFailure(Call call, IOException e) {
                LOGGER.info("onFailure data:[{}]: ", e);
            }
        });
        return result.toString();
    }




    /**
     * 同步GET请求，带请求头，请求参数
     * @param url
     * @param header
     * @param query
     * @return
     */
    public static String synGet(String url, Map<String, Object> header, Map<String, Object> query){
        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();

        // 创建一个 HttpUrl.Builder
        HttpUrl.Builder urlBuilder = request.url().newBuilder();
        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();

        // 装载请求头参数
        Iterator<Map.Entry<String, Object>> headerIterator = header.entrySet().iterator();
        headerIterator.forEachRemaining(e -> {
            headerBuilder.add(e.getKey(), (String) e.getValue());
        });

        // 装载请求的参数
        Iterator<Map.Entry<String, Object>> queryIterator = query.entrySet().iterator();
        queryIterator.forEachRemaining(e -> {
            urlBuilder.addQueryParameter(e.getKey(), (String) e.getValue());
        });

        // 设置自定义的 builder
        // 因为 get 请求的参数，是在 URL 后面追加  http://xxxx:8080/user?name=xxxx?sex=1
        builder.url(urlBuilder.build()).headers(headerBuilder.build());

        try (Response execute = okHttpClient.newCall(builder.build()).execute()) {
            return execute.body().string();
        } catch (IOException e) {
            LOGGER.error("synGet(String url, Map<String, Object> header, Map<String, Object> query):[{}] ", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    /**
     * get 请求
     * @param url 请求URL
     * @return
     * @throws Exception
     */
    public static String synGet(String url){
        return synGet(url, Maps.newHashMap());
    }


    /**
     * get 请求
     * @param url 请求URL
     * @param query 携带参数参数
     * @return
     * @throws Exception
     */
    public static String synGet(String url, Map<String, Object> query)  {
        return synGet(url, Maps.newHashMap(), query);
    }

    /**
     * 异步请求post
     */
    public static void asynPostString(){
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        String requestBody = "I am Jdqm.";
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType, requestBody))
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LOGGER.error("onFailure:[{}]: ", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LOGGER.info("onResponse:[protocol:{},code:{},message:{}]: ", response.protocol(),response.code(),response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    System.out.println("name:"+headers.name(i)+",value:"+headers.value(i));
                }
                LOGGER.info("onResponse:[{}]: ", response.body().string());
            }
        });
    }



    /**
     * JSON数据格式请求
     * @param url
     * @param header
     * @param json
     * @return
     */
    private static String synPostJson(String url, Map<String, Object> header,String json) {
        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();
        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();
        // 装载请求头参数
        Iterator<Map.Entry<String, Object>> headerIterator = header.entrySet().iterator();
        headerIterator.forEachRemaining(e -> {
            headerBuilder.add(e.getKey(), (String) e.getValue());
        });
        //FormBody默认的MediaType就是application/x-www-form-urlencoded; charset=utf-8
        RequestBody requestBody = FormBody.create(json, MediaType.parse("application/json"));
        // 设置自定义的 builder
        builder.headers(headerBuilder.build()).post(requestBody);
        try (Response execute = okHttpClient.newCall(builder.build()).execute()) {
            return execute.body().string();
        } catch (IOException e) {
            LOGGER.error("String url, Map<String, Object> header,String json:[{}] ", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    /**
     * post 请求， 请求参数 并且 携带文件上传
     * @param url
     * @param header
     * @param parameter
     * @param file 文件
     * @param fileFormName 远程接口接收 file 的参数
     * @return
     * @throws Exception
     */
    public static String synPostWithFile(String url, Map<String, Object> header, Map<String, Object> parameter, File file, String fileFormName) {
        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();
        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();
        // 装载请求头参数
        Iterator<Map.Entry<String, Object>> headerIterator = header.entrySet().iterator();
        headerIterator.forEachRemaining(e -> {
            headerBuilder.add(e.getKey(), (String) e.getValue());
        });

        // 或者 FormBody.create 方式，只适用于接口只接收文件流的情况
        // RequestBody requestBody = FormBody.create(MediaType.parse("application/octet-stream"), file);
        MultipartBody.Builder requestBuilder = new MultipartBody.Builder();
        // 状态请求参数
        Iterator<Map.Entry<String, Object>> queryIterator = parameter.entrySet().iterator();
        queryIterator.forEachRemaining(e -> {
            requestBuilder.addFormDataPart(e.getKey(), (String) e.getValue());
        });

        if (null != file) {
            // application/octet-stream
            requestBuilder.addFormDataPart(StringUtils.isNotBlank(fileFormName) ? fileFormName : "file", file.getName(), RequestBody.create(file, MediaType.parse("application/octet-stream")));
        }
        // 设置自定义的 builder
        builder.headers(headerBuilder.build()).post(requestBuilder.build());
        // 然后再 build 一下
        try (Response execute = okHttpClient.newCall(builder.build()).execute()) {
            return execute.body().string();
        } catch (IOException e) {
            LOGGER.error("synPostWithFile(String url, Map<String, Object> header, Map<String, Object> parameter, File file, String fileFormName):[{}] ", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    /**
     * post 请求， 请求参数 并且 携带文件上传二进制流
     * @param url
     * @param header
     * @param parameter
     * @param fileName 文件名
     * @param fileByte 文件的二进制流
     * @param fileFormName 远程接口接收 file 的参数
     * @return
     * @throws Exception
     */
    public static String synPostWithBytesFile(String url, Map<String, Object> header, Map<String, Object> parameter, String fileName, byte [] fileByte, String fileFormName) throws Exception {
        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();

        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();

        // 装载请求头参数
        Iterator<Map.Entry<String, Object>> headerIterator = header.entrySet().iterator();
        headerIterator.forEachRemaining(e -> {
            headerBuilder.add(e.getKey(), (String) e.getValue());
        });

        MultipartBody.Builder requestBuilder = new MultipartBody.Builder();

        // 状态请求参数
        Iterator<Map.Entry<String, Object>> queryIterator = parameter.entrySet().iterator();
        queryIterator.forEachRemaining(e -> {
            requestBuilder.addFormDataPart(e.getKey(), (String) e.getValue());
        });

        if (fileByte.length > 0) {
            // application/octet-stream
            requestBuilder.addFormDataPart(StringUtils.isNotBlank(fileFormName) ? fileFormName : "file", fileName, RequestBody.create(fileByte, MediaType.parse("application/octet-stream")));
        }

        // 设置自定义的 builder
        builder.headers(headerBuilder.build()).post(requestBuilder.build());

        try (Response execute = okHttpClient.newCall(builder.build()).execute()) {
            return execute.body().string();
        }
    }

    /**
     * post 请求  携带文件上传
     * @param url
     * @param file
     * @return
     * @throws Exception
     */
    public static String synPostWithFile(String url, File file, String fileFormName) {
        return synPostWithFile(url, Maps.newHashMap(), Maps.newHashMap(), file, fileFormName);
    }

    /**
     * post 请求
     * @param url
     * @param header 请求头
     * @param parameter 参数
     * @return
     * @throws Exception
     */
    public static String synPostWithFile(String url, Map<String, Object> header, Map<String, Object> parameter)  {
        return synPostWithFile(url, header, parameter, null, null);
    }

    /**
     * post 请求
     * @param url
     * @param parameter 参数
     * @return
     * @throws Exception
     */
    public static String synPostWithFile(String url, Map<String, Object> parameter)  {
        return synPostWithFile(url, Maps.newHashMap(), parameter, null, null);
    }

    /**
     * post请求  参数JSON格式
     * @param url
     * @param json JSON数据
     * @return
     * @throws IOException
     */
    public static String synPostJson(String url,String json){
        return synPostJson(url, Maps.newHashMap(), json);
    }

    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        //String rs = asynGet(url);
        String rs = synGet(url);
        System.out.println("rs="+rs);
    }

}
