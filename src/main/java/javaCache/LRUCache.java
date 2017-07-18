package javaCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ��LinkedHashMapʵ�ֵ�LRU��������δ�ã����档
 * 
 * ʵ����û��ʹ������࣬ʵ����ֱ����AccessStaticCache���õ������ڲ��࣬
 * ԭ��������һ���ģ�ֻ���ٶ������������ļ���
 * 
 * �ο���
 * 		http://www.cnblogs.com/lzrabbit/p/3734850.html
 *      http://docs.oracle.com/javase/7/docs/api/
 *  	http://blog.csdn.net/dyllove98/article/details/7621445
 *  
 * @author zhouna
 * @data 2017��7��14�� ����2:53:12
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	
	private static final long serialVersionUID = 1L;

	private final int MAX_CACHE_SIZE; // �����������������������ƣ���ɾ��������û���õ�����
	
	public LRUCache(int cacheSize) {
		super((int)Math.ceil(cacheSize/0.75)+1, 0.75f, true);
		MAX_CACHE_SIZE = cacheSize;
	}

	/**
	 * ������ʱ���������true����ɾ�������е���������
	 */
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> entry) {
		boolean b = size() > MAX_CACHE_SIZE;
		if (b) {
			System.out.println("Ҫ��ɾ�ˣ�" + entry.getKey() + ": " + entry.getValue());
		}
		return b;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
