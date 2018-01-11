package org.wisteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"org.wisteria", "${wisteria.app.basePackage:}"})
@SpringBootApplication
public class WisteriaSinensisApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WisteriaSinensisApplication.class, args);
	}
	
	/*
	private static String[] additionalArgs(String[] args) {
		AppModuleLoader loader = new AppModuleLoader();
		Properties properties = loader.scan();
		return convert2Args(properties);
	}
	
	private static String[] convert2Args(Properties properties) {
        String[] ret = new String[properties.size()];
        Set<Object> keys = properties.keySet();
        int idx = 0;
        for (Object key : keys) {
            String cfgValue = properties.get(key).toString();
            if (StringUtils.hasText(cfgValue)) {
                String arg = "--" + key.toString() + "=" + cfgValue;
                ret[idx++] = arg;
            } else {
                ret[idx++] = "";
            }
        }
        return ret;
    }
    */
}
