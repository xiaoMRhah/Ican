package com.maven.springmvc;

import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

/*import java.util.HashMap;
import java.util.Map;*/

/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PayController {
	/*@RequestMapping(value="/wxpay",method=RequestMethod.GET)
	public String test(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		
		
		Map map=new HashMap();
		map.put("test", "Hello World!!");
		model.addAttribute("message", "Hello World!!!");
		return "wxpay";
	}*/
	
	
	@RequestMapping(value="/wxpay",method=RequestMethod.GET)
	public String couponsConfirm(Model m,String openid,HttpServletRequest request) throws IOException{
		
		//openid可通过微信高级接口oath2.0网页授权接口获取到用户信息
		/*m.addAttribute("openid",openid);*/
		openid="ohZ_m009HuTIRH5g6KaZRnfRACcg";
		//orderNo是你的商品订单号，自行生成的随机订单号，但要保证随机性，不能有重复订单号。
		String orderNo="123456";
		m.addAttribute("orderNo",orderNo);
		
		String timeStamp=payConmmonUtil.create_timestamp();
		String nonceStr=payConmmonUtil.create_nonce_str();
		m.addAttribute("appid",ConfigUtil.APPID);
		m.addAttribute("timestamp",timeStamp);
		m.addAttribute("nonceStr",nonceStr);
		m.addAttribute("openid", openid);
		
		String prepayId=WxPayUtil.unifiedorder("瓢虫", orderNo, openid);
		
		SortedMap<Object,Object> signParams=new TreeMap<Object,Object>();
		signParams.put("appId", ConfigUtil.APPID);
		signParams.put("nonceStr", nonceStr);
		signParams.put("package1", "prepay_id="+prepayId);
		signParams.put("timeStamp", timeStamp);
		signParams.put("signType", "MD5");
		
		//生成支付签名，要采用URLENCODER的原始值进行SHA1算法
		String sign=payConmmonUtil.createSign(signParams);
		
		m.addAttribute("paySign",sign);
		m.addAttribute("packageValue", "prepay_id="+prepayId);
		
		return "wxpay";
	}
}
