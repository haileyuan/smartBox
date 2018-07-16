package com.Iot;

import java.util.Date;

import javax.servlet.ServletContextEvent;

 
import org.springframework.web.context.ContextLoaderListener;

import com.Iot.IotClient;
 
/**
 * 设置监听
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
			System.out.println("MQTT线程启动......");
			String time = new Date().toString();
			IotClient.initMessage(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
}