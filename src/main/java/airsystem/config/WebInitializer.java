package airsystem.config;

import java.nio.charset.StandardCharsets;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Tomcat启动的时候会检测是否有WebApplicationInitializer接口的类
 * 若检测到有这个类，就会实例化它，并调用它的onStartup方法
 * @author Administrator
 *
 */
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(servletContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		//.添加字符编码的过滤器
		FilterRegistration.Dynamic  encodingFliter=
				servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		encodingFliter.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
		encodingFliter.setInitParameter("forceEncoding", "true");
		encodingFliter.addMappingForUrlPatterns(null, false, "/*");
	}
}
/*
 * 你想使用Spring，就得有Spring容器的实例
 * 你想使用Spring MVC，就得配置DispatcherServlet的实例
 * 还要把这两个东西放到ServletContext对象里，因为他们俩都是重量级对象
 * 
 * */
 



