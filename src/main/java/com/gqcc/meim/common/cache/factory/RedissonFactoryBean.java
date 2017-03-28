package com.gqcc.meim.common.cache.factory;

import com.gqcc.meim.common.cache.RedissonTemplate;
import com.gqcc.meim.common.cache.config.RedissonPoolConfig;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

public class RedissonFactoryBean implements DisposableBean, FactoryBean<RedissonTemplate> {

	RedissonPoolConfig config;

	private RedissonClient redisson;
	


	@Override
	public RedissonTemplate getObject() throws Exception {

		redisson = Redisson.create(config.getConfig());
		RedissonTemplate template = new RedissonTemplate();
		template.setRedisson(redisson);
		return template;
	}

	
	@Override
	public Class<?> getObjectType() {

		return RedissonTemplate.class;
	}

	@Override
	public boolean isSingleton() {

		return true;
	}

	public RedissonPoolConfig getConfig() {
		return config;
	}

	public void setConfig(RedissonPoolConfig config) {
		this.config = config;
	}

	@Override
	public void destroy() throws Exception {

		if (redisson != null) {
			synchronized (this) {
				if (redisson != null) {
					redisson.shutdown();
				}
			}
		}

	}

}
