package model;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class URL {
	private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemSearch.aspx?";

	public static String GetUrl(String searchWord, String queryType) throws Exception {
		Map<String,String> hm = new HashMap<String,String>();
		hm.put("ttbkey", "ttblkjs82691117001");						//승인키
		hm.put("Query", URLEncoder.encode(searchWord, "UTF-8"));	//검색어
		hm.put("QueryType", URLEncoder.encode(queryType, "UTF-8"));	//검색어 종류(KeyWord :제목+저자, Title:제목검색, Author:저자검색, Publisher:출판사검색)
		hm.put("MaxResults", "10");		//검색결과 한 페이지 출력개수
		hm.put("start", "1");			//검색결과 시작 페이지
		hm.put("SearchTarget", "Book");	//검색 대상
		hm.put("output", "xml");		//요청결과 출력방법

		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val  = hm.get(key);
			sb.append(key).append("=").append(val).append("&");
		}

		return BASE_URL + sb.toString();
	}
}
