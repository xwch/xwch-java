package com.xwch.utils;


import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;


public final class HttpClientUtil {

    private static RequestConfig config;

    private static HttpClientUtil httpClientUtil;

    private HttpClientUtil() {
    }

    public static HttpClientUtil createHttpClientUtil(int connTimeout, int reqTimeout) {
        config = RequestConfig.custom().setConnectTimeout(connTimeout).setSocketTimeout(reqTimeout).build();
        httpClientUtil = new HttpClientUtil();
        return httpClientUtil;
    }

    public static HttpClientUtil createHttpClientUtil(int connTimeout, int reqTimeout, String proxyHost, int proxyPort) {
        config = RequestConfig.custom().setConnectTimeout(connTimeout).setSocketTimeout(reqTimeout)
                .setProxy(new HttpHost(proxyHost, proxyPort)).setAuthenticationEnabled(true).build();
        httpClientUtil = new HttpClientUtil();
        return httpClientUtil;
    }

    public static HttpClientUtil createHttpClientUtil() {
        return createHttpClientUtil(180000, 180000);
    }

    public String sendByPost(String url, Map<String, String> param) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(url);
            List<NameValuePair> paraList = Lists.newArrayList();
            if (!param.isEmpty()){
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    paraList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                httpPost.setEntity(new StringEntity(param.get("body"), Consts.UTF_8));
            }
            httpPost.setConfig(config);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            //log.info("statusCode:{}", statusCode);
            System.out.println("statusCode:"+statusCode);
            checkArgument(Objects.equal(statusCode, HttpStatus.SC_OK), "响应码状态不是200");
            return EntityUtils.toString(entity,"UTF-8");

        } finally {
            if (httpPost != null) {
                httpPost.releaseConnection();
            }
            httpClient.close();
        }
    }


    public String sendByGet(String url, Map<String, String> param) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = null;
        try {
            StringBuilder paramUrl = new StringBuilder();
            if (param != null) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    paramUrl.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
            httpGet = new HttpGet(url + paramUrl);
            httpGet.setConfig(config);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            checkArgument(Objects.equal(statusCode, HttpStatus.SC_OK), "响应码状态不是200");
            return EntityUtils.toString(entity);
        } catch (Exception e) {
            System.out.println("exception："+e);
            return "";
        }finally {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
            httpClient.close();
        }
    }
}
