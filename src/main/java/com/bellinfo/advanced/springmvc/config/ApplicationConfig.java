package com.bellinfo.advanced.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "com.bellinfo.advanced.springmvc")
@EnableWebMvc
@EnableTransactionManagement
public class ApplicationConfig  {

    @Resource
    Environment environment;

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
   public DataSource dataSource(){
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName(environment.getProperty("pg.driver"));
        dm.setUrl(environment.getProperty("pg.url"));
        dm.setUsername(environment.getProperty("pg.user"));
        dm.setPassword(environment.getProperty("pg.pass"));
        return dm;
   }

   @Bean
    public LocalSessionFactoryBean sessionFactory(){
        Properties pro = new Properties();
        pro.put("hibernate.dialect",environment.getProperty("hib.dialect"));
        pro.put("hibernate.hbm2ddl.auto",environment.getProperty("hib.ddl.strategy"));
        pro.put("hibernate.show_sql",environment.getProperty("hib.show.queries"));

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(pro);
        sessionFactory.setPackagesToScan(environment.getProperty("hib.entity.scan"));
        return sessionFactory;
   }

   @Bean
    public HibernateTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory().getObject());
        return htm;
   }

}
