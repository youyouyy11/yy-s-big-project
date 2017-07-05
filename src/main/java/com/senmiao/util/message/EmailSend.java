package com.senmiao.util.message;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class EmailSend {
	
	private final static String url = "http://sendcloud.sohu.com/webapi/mail.send.json";
	private final static String apiUser = "benzhreva";
	private final static String apiKey = "7Poz9wqMKTHPGCng";
	
	
	public String sendAndCc(String to, String subject, String content){
		
        //创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        //HttpClient  
        CloseableHttpClient httpclient = httpClientBuilder.build(); 
        
		HttpPost httppost = new HttpPost(url);
		String result = "unsuccess";
		
		List<BasicNameValuePair> params = new ArrayList<>();
		// 不同于登录SendCloud站点的帐号，您需要登录后台创建发信子帐号，使用子帐号和密码才可以进行邮件的发送。
		params.add(new BasicNameValuePair("api_user", apiUser));
		params.add(new BasicNameValuePair("api_key", apiKey));
		params.add(new BasicNameValuePair("from", "benzhr_eva@163.com"));
		params.add(new BasicNameValuePair("fromname", "本智科技"));
		params.add(new BasicNameValuePair("to", to));
		params.add(new BasicNameValuePair("subject", subject));
		params.add(new BasicNameValuePair("html", content));
		params.add(new BasicNameValuePair("resp_email_id", "true"));

		try {
			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			// 请求
			HttpResponse response = httpclient.execute(httppost);
			// 处理响应
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
				// 读取xml文档
				result = EntityUtils.toString(response.getEntity());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		httppost.releaseConnection();
		
		return result;
	}

}
