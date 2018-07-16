package com.yiibai.springmvc;

import java.util.Date;

import javax.servlet.ServletContextEvent;

 
import org.springframework.web.context.ContextLoaderListener;

import com.Iot.IotClient;
 
/**
 * ���webroot������·��.
 * @author youway
 *
 */
public class WebRootPathListener extends ContextLoaderListener {

	public void contextDestroyed(ServletContextEvent sce) {  
        }
    
    public void contextInitialized(ServletContextEvent sce) {  
        String webRootPath = sce.getServletContext().getRealPath("/");  
        System.setProperty("webRoot.path" , webRootPath);  
        try {
			System.out.println("IotClient�߳�����......");
			String time = new Date().toString();
			IotClient.initMessage("aaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
}