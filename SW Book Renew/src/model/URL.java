package model;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class URL {
	private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemSearch.aspx?";
	private static final String BASE_URL2 = "http://www.aladdin.co.kr/ttb/api/ItemList.aspx?";

	public static String GetUrl(String searchWord, String queryType) throws Exception {
		Map<String,String> hm = new HashMap<String,String>();
		hm.put("ttbkey", "ttblkjs82691117001");						//����Ű
		hm.put("Query", URLEncoder.encode(searchWord, "UTF-8"));	//�˻���
		hm.put("QueryType", URLEncoder.encode(queryType, "UTF-8"));	//�˻��� ����(KeyWord :����+����, Title:����˻�, Author:���ڰ˻�, Publisher:���ǻ�˻�)
		hm.put("MaxResults", "10");		//�˻���� �� ������ ��°���
		hm.put("start", "1");			//�˻���� ���� ������
		hm.put("SearchTarget", "Book");	//�˻� ���
		hm.put("output", "xml");		//��û��� ��¹��

		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val  = hm.get(key);
			sb.append(key).append("=").append(val).append("&");
		}

		return BASE_URL + sb.toString();
	}
	
	public static String GetUrl2(String QueryType) throws Exception {
		Map<String,String> hm = new HashMap<String,String>();
		hm.put("ttbkey", "ttblkjs82691117001");						//����Ű
		hm.put("QueryType", URLEncoder.encode(QueryType, "UTF-8"));	//�˻��� ����(KeyWord :����+����, Title:����˻�, Author:���ڰ˻�, Publisher:���ǻ�˻�)
		hm.put("MaxResults", "10");		//�˻���� �� ������ ��°���
		hm.put("start", "1");			//�˻���� ���� ������
		hm.put("SearchTarget", "Book");	//�˻� ���
		hm.put("output", "xml");		//��û��� ��¹��
		hm.put("Version", "20131101");

		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val  = hm.get(key);
			sb.append(key).append("=").append(val).append("&");
		}

		return BASE_URL2 + sb.toString();
	}
	
	public static String GetUrl(String searchWord, String queryType, int page) throws Exception {
		Map<String,String> hm = new HashMap<String,String>();
		hm.put("ttbkey", "ttblkjs82691117001");						//����Ű
		hm.put("Query", URLEncoder.encode(searchWord, "UTF-8"));	//�˻���
		hm.put("QueryType", URLEncoder.encode(queryType, "UTF-8"));	//�˻��� ����(KeyWord :����+����, Title:����˻�, Author:���ڰ˻�, Publisher:���ǻ�˻�)
		hm.put("MaxResults", "10");		//�˻���� �� ������ ��°���
		hm.put("start", URLEncoder.encode(Integer.toString(page), "UTF-8"));			//�˻���� ���� ������
		hm.put("SearchTarget", "Book");	//�˻� ���
		hm.put("output", "xml");		//��û��� ��¹��

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
