package com.boot.cache;

import java.util.Map;
import java.util.Set;

/** <br>
 * 标题: 通用缓存接口<br>
 * 描述: 提供基本的get、set、delete方法<br>
 * 公司: www.tydic.com<br>
 * 
 * @autho liuce
 * @time 2016-7-18 下午1:06:30 */
public interface CacheService {

	/** 往缓存中存放值（永不过期）<br>
	 * 适用场景: 需要常驻缓存中的数据<br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @autho liuce
	 * @time 2016-7-18 下午1:21:38 */
	public void put(String key, Object value);

	/** 往缓存中存放值（一段时间内有效）<br>
	 * 适用场景: 需要常驻缓存中的数据<br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 *        失效时间，0表示用不失效
	 * @return
	 * @autho liuce
	 * @time 2016-7-18 下午1:21:38 */
	public void put(String key, Object value, int expire);

	/** 从缓存中获取值<br>
	 * 适用场景: <br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param key
	 * @return
	 * @autho liuce
	 * @time 2016-7-18 下午1:22:59 */
	public Object get(String key);

	/** 从缓存中获取指定类型的结果<br>
	 * 适用场景: <br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param key
	 * @param requiredType
	 * @return
	 * @autho liuce
	 * @time 2016年9月9日 下午3:15:49 */
	public <T> T get(String key, Class<T> requiredType);

	/** 从缓存中删除指定的key<br>
	 * 适用场景: <br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param key
	 * @autho liuce
	 * @time 2016-7-18 下午1:23:43 */
	public void delete(String key);

	/** 穿透查询<br>
	 * 适用场景: <br>
	 * 调用方式: 同步HSF方式调用<br>
	 * 业务逻辑说明<br>
	 * 做穿透查询，缓存中查询不到的数据通过本地查询执行器回调改执行器得到数据，最后放入缓存
	 * 
	 * @param <T>
	 * @param executer
	 *        本地查询执行器
	 * @param key
	 *        支持多个参数，以多个String参数连接作为key
	 * @return
	 * @autho liuce
	 * @time 2016-7-27 下午1:55:13 */
	public <T> T getFinal(CacheExecuterService<T> executer, String... key);

	/** 根据表达式获取前缀一样的Key集合<br>
	 * 适用场景: <br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param pattern
	 * @return
	 * @autho liuce
	 * @time 2016年9月25日 下午3:11:59 */
	public Set<String> getkeys(String pattern);

	/** 获取key的失效时间<br>
	 * 适用场景: <br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param key
	 * @return
	 * @autho liuce
	 * @time 2016年11月9日 上午12:10:41 */
	public Long getExpireTimeByKey(String key);

	/** <br>
	 * 适用场景: 获取组合服务响应码<br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param executer
	 * @param key
	 * @return
	 * @autho QIJIANFEI
	 * @time 2017年8月4日 下午8:52:35 */
	Map<String, String> getOuterCodeByKey(CacheExecuterService<Map<String, String>> executer, String... key);

	/** <br>
	 * 适用场景:获取业务服务响应码 <br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param executer
	 * @param key
	 * @return
	 * @autho QIJIANFEI
	 * @time 2017年8月4日 下午8:52:59 */
	Map<String, String> getInnerCodeByKey(CacheExecuterService<Map<String, String>> executer, String... key);

}
