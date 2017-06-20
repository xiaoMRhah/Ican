package com.maven.springmvc;

/*import java.util.HashMap;
import java.util.Map;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PayController {
	@RequestMapping(value="/wxpay",method=RequestMethod.GET)
	public String test(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		
		
		/*Map map=new HashMap();
		map.put("test", "Hello World!!");*/
		model.addAttribute("message", "Hello World!!!");
		return "wxpay";
	}
}
