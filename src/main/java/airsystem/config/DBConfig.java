package airsystem.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/*
 * 数据库配置
 * 1.要告诉配置类你的配置信息配置@PropertySource
 * 2.利用IOC功能注入配置信息
 * */
@Configuration
@EnableTransactionManagement
@MapperScan("airsystem.mapper")
@PropertySource("classpath:jdbc.properties")
public class DBConfig {
	@Value("${jdbc.driverClass}")
    private String driver;
	@Value("${jdbc.url}")
    private String url;
	@Value("${jdbc.username}")
    private String username;
	@Value("${jdbc.password}")
    private String password;
	
	//2数据库连接池
	@Bean(name="dataSource")
	public DataSource creatDataSource() {
		DruidDataSource ds=new DruidDataSource();//c3p0  
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
		
	}
	
	//Mybatis的配置
			@Value("${mybatis.config.path}")
			private String myBatisConfigPath;
			@Value("${mybatis.mapper.xml.config.path}")
			private String mapperXmlConfigPath;
			@Value("${mybatis.alias.package.path}")
			private String aliasPackagePath;
		
		
			@Bean(name="sqlSessionFactory")
			public SqlSessionFactory createSqlSessionFactory(DataSource dataSource) throws Exception {
				SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
				PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
				String packageXmlConfigPath=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperXmlConfigPath;
				sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(myBatisConfigPath));
				sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageXmlConfigPath));
				sqlSessionFactoryBean.setDataSource(dataSource);
				sqlSessionFactoryBean.setTypeAliasesPackage(aliasPackagePath);
				
				return sqlSessionFactoryBean.getObject();
				
				
			}
	
	
	//配置JdbcTemplate
	@Bean(name="jdbcTemplate")
	public JdbcTemplate creatsJdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);//利用数据源构造JdbcTemplate
		
	}
	
	//配置事务管理器
	@Bean(name="transactionManager")
	public PlatformTransactionManager createTransactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
}
