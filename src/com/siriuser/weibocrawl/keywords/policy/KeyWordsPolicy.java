package com.siriuser.weibocrawl.keywords.policy;

/**
 * @author huangzheng
 */
public interface KeyWordsPolicy {
	
	String getKeyWord(String keyWordLine, String siteLine);
	
}
