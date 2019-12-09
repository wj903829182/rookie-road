package com.jack.common.util;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created By Jack on 2019/12/4
 *
 * @author Jack
 * @date 2019/12/4 20:17
 * @Description:
 * 网络请求工具类
 * https://www.jianshu.com/p/da4a806e599b
 */
public class OkhttpUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(OkhttpUtils.class);
    private OkhttpUtils() {
    }
    public static String asynGet(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                //默认就是GET请求，可以不写
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LOGGER.info("onResponse data:[{}]: ", response.body().string());
            }
            @Override
            public void onFailure(Call call, IOException e) {
                LOGGER.info("onFailure data:[{}]: ", e);
            }
        });
        return null;
    }

    public static void main(String[] args) {

    }

}
