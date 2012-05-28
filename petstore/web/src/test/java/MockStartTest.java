import javax.servlet.ServletContextEvent;

import junit.framework.TestCase;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockServletContext;

import com.alibaba.citrus.logconfig.LogConfiguratorListener;
import com.alibaba.citrus.webx.context.WebxContextLoaderListener;

public class MockStartTest extends TestCase {
	public final String resourceBasePath = "/Users/admin/git/citrus-sample/petstore/web/src/main/webapp";
	public void test_mock() throws Exception {
		MockResoruceLoader resourceLoader = new MockResoruceLoader();
		MockServletContext context = new MockServletContext(resourceBasePath, resourceLoader) {
			public void log(String message) {
				System.out.println(message);
			}
		};
		
		{
			LogConfiguratorListener listener = new LogConfiguratorListener();
			listener.contextInitialized(new ServletContextEvent(context));
		}
		{
			WebxContextLoaderListener listener = new WebxContextLoaderListener();
			listener.contextInitialized(new ServletContextEvent(context));
		}
	}
	
	protected String getResourceLocation(String path) {
		return this.resourceBasePath + path;
	}
	
	public class MockResoruceLoader extends DefaultResourceLoader {
		public Resource getResource(String location) {
//			System.out.println("resource " + location);
			FileSystemResource resource = new FileSystemResource(location);
			
			if (resource.exists()) {
				return resource;
			}
			
			return super.getResource(location);
		}
	}
}
