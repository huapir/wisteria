package org.wisteria.core.configuration;

import java.lang.annotation.Annotation;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.wisteria.core.app.ModuleConstants;

/**
 * 
 * @author HuaShengPi
 *
 */
@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class MybatisConfiguration implements EnvironmentAware {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

	private static final String MYBATIS_MAPPER_ANNOTATION = "org.apache.ibatis.annotations.Mapper";
	
	private String moduleMapperScanBasePackage;
    
	@Override
	public void setEnvironment(Environment environment) {
        moduleMapperScanBasePackage = environment.resolvePlaceholders("${"+ ModuleConstants.APP_MODULES_BASE_PACKAGES + ":}");
        logger.info("wisteria load "  + ModuleConstants.APP_MODULES_BASE_PACKAGES + ":" + moduleMapperScanBasePackage);
	}
	
	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() throws ClassNotFoundException {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(moduleMapperScanBasePackage);
        mapperScannerConfigurer.setAnnotationClass(Class.forName(MYBATIS_MAPPER_ANNOTATION).asSubclass(Annotation.class));
        return mapperScannerConfigurer;
    }

}
