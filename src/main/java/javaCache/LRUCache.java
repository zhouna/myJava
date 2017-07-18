package javaCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用LinkedHashMap实现的LRU（最近最久未用）缓存。
 * 
 * 实际上没有使用这个类，实际是直接在AccessStaticCache中用的匿名内部类，
 * 原理和这个是一样的，只是少定义了两个类文件。
 * 
 * 参考：
 * 		http://www.cnblogs.com/lzrabbit/p/3734850.html
 *      http://docs.oracle.com/javase/7/docs/api/
 *  	http://blog.csdn.net/dyllove98/article/details/7621445
 *  
 * @author zhouna
 * @data 2017年7月14日 下午2:53:12
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	
	private static final long serialVersionUID = 1L;

	private final int MAX_CACHE_SIZE; // 缓存最大容量，超过这个限制，就删除最近最久没有用的数据
	
	public LRUCache(int cacheSize) {
		super((int)Math.ceil(cacheSize/0.75)+1, 0.75f, true);
		MAX_CACHE_SIZE = cacheSize;
	}

	/**
	 * 容器满时，如果返回true，就删掉参数中的那条数据
	 */
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> entry) {
		boolean b = size() > MAX_CACHE_SIZE;
		if (b) {
			System.out.println("要被删了：" + entry.getKey() + ": " + entry.getValue());
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
