package com.siriuser.weibocrawl.keywords.policy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * @author huangzheng
 *
 */
public class SinaKeyWordsPolicy implements KeyWordsPolicy {

	@Override
	public String getKeyWord(String keyWordLine, String siteLine) {
		
		String keyWord = null;

		keyWordLine = keyWordLine.replaceAll("\"", "");
		keyWordLine = keyWordLine.replaceAll("AND", " ");
		keyWordLine = keyWordLine.replaceAll("OR", "|");
//		keyWordLine = keyWordLine.replaceAll("(", "");
//		keyWordLine = keyWordLine.replaceAll(")", "");
		
		if (keyWordLine.contains("|")) {
			
			String[] tempStrings = keyWordLine.split("|");
			if (tempStrings.length > 3) {
				for (int i=0; i<3 ;i++) {
					keyWord += tempStrings[i];
					keyWord += "|";
				}
			}else {
				keyWord = keyWordLine;
			}
		}else {
			keyWord = keyWordLine;
		}
        //新浪url进行了2次encode
		return java.net.URLEncoder.encode(java.net.URLEncoder.encode(keyWord));
	}

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.print(URLEncoder.encode("测试","utf-8"));
    }

}
