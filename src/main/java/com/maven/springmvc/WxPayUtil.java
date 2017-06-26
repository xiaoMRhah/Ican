package com.maven.springmvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class WxPayUtil {
	@SuppressWarnings("unchecked")
	public static String unifiedorder(String body,String out_trade_no,String openid) throws IOException
	{
		SortedMap<Object,Object> parameters=new TreeMap<Object,Object>();
		parameters.put("appid", ConfigUtil.APPID);
		parameters.put("mch_id", ConfigUtil.MCH_ID);
		parameters.put("nonce_str", payConmmonUtil.CreateNoncestr());
		parameters.put("body", body);
		parameters.put("out_trade_no", out_trade_no);
		parameters.put("total_free", 1);
		parameters.put("spbill_create_ip", "113.57.246.11");
		parameters.put("notify_url", ConfigUtil.NOTIFY_URL);
		parameters.put("trade_type", "JSAPI");
		parameters.put("openid", openid);
		String sign=payConmmonUtil.createSign(parameters);
		parameters.put("sign", sign);
		String requestXML=payConmmonUtil.getRequestXml(parameters);
		System.out.println(requestXML.toString());
		String result=CommonUtil.httpsReqeust(ConfigUtil.UNIFIED_ORDER_URL, "POST", requestXML);
		System.out.println(result.toString());
		Map<String,String> map=new HashMap<String,String>();
		try{
			map = XMLUtil.doXMLParse(result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map.get("prepay_id").toString();		
	}
}
