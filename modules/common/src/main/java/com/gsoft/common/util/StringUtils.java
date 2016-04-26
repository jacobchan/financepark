package com.gsoft.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gsoft.framework.core.exception.BusException;

public class StringUtils {

	/**将字符串某字符替换
	 * @param source
	 * @param c
	 * @param params
	 * @return
	 */
	public static String replaceChar(String source, char c, String... params) {
		if (source != null && !"".equals(source)) {
			String[] tempArray = (source+"_").split("" + c + "");
			int countC = tempArray.length - 1;
			if (countC == params.length) {
				Pattern pattern = Pattern.compile("" + c + "");
				Matcher matcher = pattern.matcher(source);
				int i = 0;
				boolean result = matcher.find();
				StringBuffer sb = new StringBuffer();
				while (result) {
					matcher.appendReplacement(sb, params[i]);
					i++;
					result = matcher.find();
				}
				matcher.appendTail(sb);
				return sb.toString();
			} else {
				throw new BusException("参数个数不一致");
			}
		}
		return source;
	}
	
	/**包含集合值的个数
	 * @param str
	 * @param parts
	 * @return
	 */
	public static int contantCount(String str,List<String> parts){
		Pattern pattern = Pattern.compile(com.gsoft.framework.util.StringUtils.arrayToDelimitedString(parts.toArray(), "|"));
		Matcher matcher = pattern.matcher(str);
		int count = 0;
		while(matcher.find()){
			count++;
		}
		return count;
	}
	
	/**
	 * 替换单个
	 * @param str
	 * @param target
	 * @param replacement
	 * @return
	 */
	public static String replaceString(String str,String target,String replacement){
		if(com.gsoft.framework.util.StringUtils.isNotEmpty(str)){
			if(str.contains(target)){
				return str.replaceAll(target, replacement);
			}
		}
		return str;
	}
	
	/**替换字符串中多个占位符,占位符限定为targets的值
	 * @param str
	 * @param targets
	 * @param replaceMap
	 * @return
	 */
	public static String replaceAllString(String str,List<String> targets,Map<String,String> replaceMap){
		if(com.gsoft.framework.util.StringUtils.isNotEmpty(str)){
			List<String> tempTargets = new ArrayList<String>();
			tempTargets.addAll(targets);
			for(String target:targets){
				tempTargets.remove(target);
				if(str.contains(target)){
					return replaceAllString(replaceString(str,target,replaceMap.get(target)), tempTargets, replaceMap);
				}
			}
		}
		return str;
	}
	
	/**替换字符串中多个占位符,占位符没有要求
	 * @param str
	 * @param targets
	 * @param replaceMap
	 * @return
	 */
	public static String replaceAllString(String str,Map<String,String> replaceMap){
		if(com.gsoft.framework.util.StringUtils.isNotEmpty(str)){
			for(Map.Entry<String, String> entry:replaceMap.entrySet()){
				String result = str.replace(entry.getKey(), entry.getValue());
				str = result;
			}
		}
		return str;
	}
	
	public static String extractCode(String codeStr){
		
		return Pattern.compile("[^0-9]").matcher(codeStr).replaceAll("");
	}
	
	public static void main(String[] args) {
		String s = "挂电视柜123456，挂电视柜给对方";
		System.out.println(extractCode(s));
	}
	
}
