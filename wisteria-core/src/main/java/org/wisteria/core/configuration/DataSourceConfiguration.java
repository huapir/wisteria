package org.wisteria.core.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @author HuaShengPi
 *
 */
@Configuration
public class DataSourceConfiguration {

	@Bean
    public PageHelper pageHelper() {
        Properties properties  = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");
        PageHelper pageHelper = new PageHelper();
        pageHelper.setProperties(properties );
        return pageHelper;
    }
	
}
