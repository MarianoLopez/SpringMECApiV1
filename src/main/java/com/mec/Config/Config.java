package com.mec.Config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableScheduling//tareas
@EnableTransactionManagement//Enables Spring's annotation-driven transaction management capability, similar to the support found in Spring's <tx:*> XML namespace
public class Config {
  /*@Value("${variable}") -> recupera el valor de ${variable} desde src/main/resources/application.properties*/
  @Value("${db.driver}")
  private String DB_DRIVER;
  
  @Value("${db.password}")
  private String DB_PASSWORD;
  
  @Value("${db.url}")
  private String DB_URL;
  
  @Value("${db.Pof2}")
  private String POF2;
  
  @Value("${db.GE}")
  private String GE;
  
  @Value("${db.Passport}")
  private String Passport;
  
  @Value("${db.username}")
  private String DB_USERNAME;

  @Value("${hibernate.dialect}")
  private String HIBERNATE_DIALECT;
  
  @Value("${hibernate.show_sql}")
  private String HIBERNATE_SHOW_SQL;
  
  @Value("${hibernate.hbm2ddl.auto}")
  private String HIBERNATE_HBM2DDL_AUTO;

  @Value("${entitymanager.packagesToScan.Pof2}")
  private String ENTITYMANAGER_PACKAGES_TO_SCAN_Pof2;
  
  @Value("${entitymanager.packagesToScan.GE}")
  private String ENTITYMANAGER_PACKAGES_TO_SCAN_GE;
  
  /*@Value("${hibernate.default_schema}")
  private String SCHEMA;*/
  
  @Primary/*necesario para multiples Beans*/
  @Bean("dataPof2")
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(DB_DRIVER);
    dataSource.setUrl(DB_URL+POF2);
    dataSource.setUsername(DB_USERNAME);
    dataSource.setPassword(DB_PASSWORD);
    return dataSource;
  }
  /*config hibernate*/
  @Primary
  @Bean("sessionPof2")
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN_Pof2);
    Properties hibernateProperties = new Properties();
    hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
    hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
    hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
    hibernateProperties.put("hibernate.default_catalog", POF2);
    hibernateProperties.put("hibernate.default_schema", "dbo");
    sessionFactoryBean.setHibernateProperties(hibernateProperties);
    return sessionFactoryBean;
  }
  
  @Primary
  @Bean("managerPof2")//gestor
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }
/**********JACKSON*************/  
  
@Bean//Avoid Jackson serialization on non fetched lazy objects
public Module datatypeHibernateModule() {return new Hibernate5Module();}

/**********TASK*************/ 
@Bean
public TaskScheduler taskScheduler() {return new ConcurrentTaskScheduler();}

@Bean
public Executor taskExecutor() {return new SimpleAsyncTaskExecutor();}
 
/********DB2***********/

@Bean("dataGE")
public DataSource dataSource2() {
  DriverManagerDataSource dataSource = new DriverManagerDataSource();
  dataSource.setDriverClassName(DB_DRIVER);
  dataSource.setUrl(DB_URL+GE);
  dataSource.setUsername(DB_USERNAME);
  dataSource.setPassword(DB_PASSWORD);
  return dataSource;
}
/*config hibernate*/
@Bean("sessionGE")
public LocalSessionFactoryBean sessionFactory2() {
  LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
  sessionFactoryBean.setDataSource(dataSource2());
  sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN_GE);
  Properties hibernateProperties = new Properties();
  hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
  hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
  hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
  hibernateProperties.put("hibernate.default_schema", "dbo");
  hibernateProperties.put("hibernate.default_catalog", GE);
  sessionFactoryBean.setHibernateProperties(hibernateProperties);
  return sessionFactoryBean;
}

@Bean("managerGE")//gestor
public HibernateTransactionManager transactionManager2() {
  HibernateTransactionManager transactionManager = new HibernateTransactionManager();
  transactionManager.setSessionFactory(sessionFactory().getObject());
  return transactionManager;
}


/********DB3***********/

@Bean("dataPassport")
public DataSource dataSource3() {
  DriverManagerDataSource dataSource = new DriverManagerDataSource();
  dataSource.setDriverClassName(DB_DRIVER);
  dataSource.setUrl(DB_URL+Passport);
  dataSource.setUsername(DB_USERNAME);
  dataSource.setPassword(DB_PASSWORD);
  return dataSource;
}
/*config hibernate*/
@Bean("sessionPassport")
public LocalSessionFactoryBean sessionFactory3() {
  LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
  sessionFactoryBean.setDataSource(dataSource3());
  //sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN_GE);
  Properties hibernateProperties = new Properties();
  hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
  hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
  hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
  hibernateProperties.put("hibernate.default_schema", "dbo");
  hibernateProperties.put("hibernate.default_catalog", Passport);
  sessionFactoryBean.setHibernateProperties(hibernateProperties);
  return sessionFactoryBean;
}

@Bean("managerPassport")//gestor
public HibernateTransactionManager transactionManager3() {
  HibernateTransactionManager transactionManager = new HibernateTransactionManager();
  transactionManager.setSessionFactory(sessionFactory().getObject());
  return transactionManager;
}
}
