package com.ewen.pay.utils.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSON;
import com.ewen.pay.utils.HttpRequest;

class HttpTest implements Runnable {

	public void run() {
		HttpRequestTest test = new HttpRequestTest();
		test.postTest();
	}
}

public class HttpRequestTest {
	public void postTest() {
		
		//String url = "http://172.17.1.200:8200/gateway/api/payOrderRRJ.do";
		//String url = "http://172.17.1.200:8200/yjpay/payback";
		//String url = "http://172.17.1.124:7001/";
		String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=12345678";
		
		String response1 = HttpRequest.get(url, "");
		System.out.println("=========== {11}" + response1);
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("key", "hello");
		String response = HttpRequest.post(url, param);
		System.out.println("=========== {}" + response);
		
		String pp = JSON.toJSONString(param);
		response = HttpRequest.postJson(url, pp);
		System.out.println("========" + response);
	}
	
	public static void main(String[] args) throws Exception {  
		ExecutorService service = Executors.newFixedThreadPool(50);
		for(int i = 0;i < 1;i++) {
			service.execute(new HttpTest());
		}
	}
}
