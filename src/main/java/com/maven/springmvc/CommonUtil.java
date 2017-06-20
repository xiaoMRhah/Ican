package com.maven.springmvc;

/*import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
*/
/** 
 * 通用工具类
 */
public class CommonUtil {
	/**
	 * 发送https请求地址
	 * @param requestUrl请求地址
	 * @param requestMethod请求方式（GET、POST）
	 * @param outputStr提交的数据
	 * @return 返回微信服务器响应的信息	
	 */
	public static String httpsReqeust(String reqeustUrl,String reqeustMethod,String outputStr){
		
	/*	//创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm={new MyX509TrustManager()};
		SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
		sslContext.init(null, tm, new Java.security.SecureRandom());
		//从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSockeFactory ssf=sslContextgetSocketFactory();*/
		
		return outputStr;
		
	}
}
