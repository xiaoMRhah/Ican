package com.maven.springmvc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * xml管理
 */
public class XMLUtil {
	/**
	 * 解析xml,返回第一集元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map<String, String> doXMLParse(String strxml) throws JDOMException,IOException{
		strxml=strxml.replaceFirst("encoding=\" .*\"  ", "encoding=\" UTF-8\"  ");
		System.err.println(strxml);
		if(null==strxml||"".equals(strxml)){
			return null;
		}
		
		Map<String, String> m=new HashMap<String, String>();
		
		InputStream in=new ByteArrayInputStream(strxml.getBytes("UTF-8"));
		SAXBuilder builder=new SAXBuilder();
		Document doc=(Document) builder.build(in);
		Element root=doc.getRootElement();
		List list=root.getChildren();
		Iterator it=list.iterator();
		while(it.hasNext()){
			Element e=(Element)it.next();
			String k=e.getName();
			String v="";
			List children=e.getChildren();
			if(children.isEmpty()){
				v=e.getTextNormalize();
			}else{
				v=XMLUtil.getChildreText(children);
			}
			m.put(k, v);
		}
		//关闭流
		in.close();
		return m;
	}

	/**
	 * 获取子节点的xml
	 * @param children
	 * @return String
	 */
	private static String getChildreText(List children) {
		StringBuffer sb=new StringBuffer();
		if(!children.isEmpty()){
			Iterator it=children.iterator();
			while(it.hasNext()){
				Element e=(Element)it.next();
				String name=e.getName();
				String value=e.getTextNormalize();
				List list=e.getChildren();
				sb.append("<"+name+">");
				if(!list.isEmpty()){
					sb.append(XMLUtil.getChildreText(list));
				}
				sb.append(value);
				sb.append("</"+name+">");
			}
		}
		return sb.toString();
	}

}
