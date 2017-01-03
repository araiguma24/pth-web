package jp.co.stylez.pth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.mvc.Controller;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "jp.co.stylez.pth", excludeFilters = { @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Controller.class) })
public class AppConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}

