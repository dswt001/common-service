package com.dake.springboot.property;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/*@Configuration
@ImportResource(value = {"classpath:application.properties"})
@PropertySource(value = {"classpath:application.properties"})*/
public class Property {

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();

//        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(Property.class);
//        String port = configApplicationContext.getEnvironment().getProperty("server.port“)");
//        System.out.println(port);
        Properties properties = new Properties();

//        if (StringUtils.isEmpty())

//        this.getClass().getClassLoader().getResource()
//        String property = properties.getProperty("server.port");
//        System.out.println(property);
        if (properties.size() == 0) {
            properties.load(new InputStreamReader(Property.class.getClassLoader().
                    getResourceAsStream("application.properties"), "UTF-8"));
        }

        System.out.println(properties.getProperty("server.port"));


    }
}
