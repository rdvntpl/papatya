package com.horizon.fps.metrics;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.horizon.fps")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import({MetricsConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter{

}
