package com.dake.springboot.property;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

//@Configuration
//@ImportResource(value = {"classpath:application.properties"})
//@PropertySource(value = {"classpath:application.properties"})
@Component
public class Property implements ApplicationContextAware, InitializingBean {

    private static ApplicationContext applicationContext;
        static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();

//        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(Property.class);
//        String port = configApplicationContext.getEnvironment().getProperty("server.port“)");
//        System.out.println(port);

//        if (StringUtils.isEmpty())

//        this.getClass().getClassLoader().getResource()
//        String property = properties.getProperty("server.port");
//        System.out.println(property);
        if (properties.size() == 0) {
            properties.load(new InputStreamReader(Objects.requireNonNull(Property.class.getClassLoader().
                    getResourceAsStream("application.properties")), StandardCharsets.UTF_8));
        }

        System.out.println(properties.getProperty("server.port"));


    }

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(applicationContext, "Property类初始化失败");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Property.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

}
