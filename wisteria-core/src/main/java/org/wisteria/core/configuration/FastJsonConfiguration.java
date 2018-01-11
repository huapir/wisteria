package org.wisteria.core.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 
 * @author HuaShengPi
 *
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * 重新实现消息转换器
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 调用父类的配置
		super.configureMessageConverters(converters);
		
		// 创建fastJson消息转换器
		FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
		// 创建fastJson配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		// 修改配置中返回内容的过滤
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteMapNullValue
				);
		
		// 处理中文乱码问题
		List<MediaType> fastMediaType = new ArrayList<>();
		fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
		fastJsonConverter.setSupportedMediaTypes(fastMediaType);
		
		fastJsonConverter.setFastJsonConfig(fastJsonConfig);
		// 将fastJson添加到视图消息转换器列表内
		converters.add(fastJsonConverter);
	}

}
