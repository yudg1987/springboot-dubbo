package com.boot.cache;

/** <br>
 * 标题: 从数据库中获取参数的回调函数接口<br>
 * 描述: <br>
 * 公司: www.tydic.com<br>
 * 
 * @autho liuce
 * @time 2016年8月15日 下午1:18:54 */
public interface CacheExecuterService<T> {

	/** 从数据库中获取参数<br>
	 * 适用场景: <br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param key
	 *        支持多个参数
	 * @return 返回值需要支持序列化
	 * @autho liuce
	 * @time 2016年8月15日 下午1:19:03 */
	public T getParamFromDb(String... key);

	/** 从数据库中获取系统内参数<br>
	 * 适用场景: <br>
	 * 调用方式: <br>
	 * 业务逻辑说明<br>
	 * 
	 * @param key
	 *        支持多个参数
	 * @return 返回值需要支持序列化
	 * @autho qijianfei
	 * @time 2016年8月15日 下午1:19:03 */
	public T getInnerParamFromDb(String... key);
}
