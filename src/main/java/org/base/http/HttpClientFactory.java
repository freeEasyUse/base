package org.base.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

/**
 * 
 * <p>Title:HttpClientFactory</p>
 * <p>description:httpClient</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月13日
 *
 */
public class HttpClientFactory {
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://www.baidu.com/");
		HttpResponse response = httpClient.execute(httpget);
		HttpEntity httpEntity = response.getEntity();
		httpEntity.getContent();
		response.getStatusLine();
		httpEntity.getContentLength();
	}
}
