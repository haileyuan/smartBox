package com.Iot;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
 
import java.util.Set;

public class IotClientFactoryBean implements InitializingBean,FactoryBean<IMqttClient>{

    private static String TCP_PROTOCOL = "tcp://";
    private static String SSL_PROTOCOL = "ssl://";
    private String protocol = TCP_PROTOCOL;
    private boolean useSsl = false;
    private String host;
	private int port ;  //= 1883;
    private String clientId = buildClientId();
    private MqttClientPersistence mqttClientPersistence;
    private String username, password;
    private MqttConnectOptions mqttConnectOptions;
    private Boolean cleanSession ;//= null;

    
   
    public IotClientFactoryBean() {
     
    	readProperties();
    	
    }
    
    public IotClientFactoryBean(String host) {
        setup(host, this.username, this.password);
        readProperties();
    }

    public IotClientFactoryBean(String host, String u, String p) {
        setup(host, u, p);
        readProperties();
    }

    public IotClientFactoryBean(String host, int port, String u, String p) {
        setup(host, u, p);
        readProperties();
    }

    public void setup(String h, String u, String p) {
        setHost(h);
        setUsername(u);
        setPassword(p);
    }

    public void setCleanSession(boolean cleanSession) {
        this.cleanSession = cleanSession;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public void setUsername(String u) {
        this.username = u;
    }

    public void setMqttConnectOptions(MqttConnectOptions mqttConnectOptions) {
        this.mqttConnectOptions = mqttConnectOptions;
    }

    public void setClientId(String c) {
        this.clientId = c;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setUseSsl(boolean useSsl) {
        this.useSsl = useSsl;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    public String getHost() {
		return host;
	}

    public void setPort(int port) {
        this.port = port;
    }

    public void setMqttClientPersistence(MqttClientPersistence mqttClientPersistence) {
        this.mqttClientPersistence = mqttClientPersistence;
    }

    @Override
    public IMqttClient getObject() throws Exception {
        String serverUri = buildServerUri();
        MqttClient client = this.mqttClientPersistence == null ?
                new MqttClient(serverUri, clientId) :
                new MqttClient(serverUri, clientId, mqttClientPersistence);
        MqttConnectOptions connectOptions = this.buildMqttConnectionOptions();
        if (null != connectOptions) {
            client.connect(connectOptions);
        } else {
            client.connect();
        }
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return IMqttClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(this.protocol, String.format("you must specify a non-null protocol value (either %s or %s)", SSL_PROTOCOL, TCP_PROTOCOL));
        Assert.isTrue(this.protocol.equalsIgnoreCase(SSL_PROTOCOL) || this.protocol.equalsIgnoreCase(TCP_PROTOCOL), "");
        Assert.hasText(this.clientId, "clientId 不能为空");
        Assert.hasText(this.host, "必须拥有一个有效的Host");
        Assert.isTrue(this.port > 0, "必须是个有效的端口");
        boolean connectionOptionsAreCorrectlySpecified =
                this.mqttConnectOptions != null && weShouldCreateConnectionOptions();
        Assert.isTrue(!connectionOptionsAreCorrectlySpecified,
                String.format("you must specify an instance of %s for the 'buildMqttConnectionOptions' attribute" +
                        " OR any of the following options ('cleanSession', 'username', 'password'), but not both!", MqttConnectOptions.class.getName()));

    }

    protected String buildServerUri() {
        if (this.useSsl) {
            this.protocol = SSL_PROTOCOL;
        }
        return this.protocol + this.host + ":" + this.port;
    }

    protected boolean weShouldCreateConnectionOptions() {
        return (this.cleanSession != null || StringUtils.hasText(this.username) || StringUtils.hasText(this.password));
    }

    protected String buildClientId() {
        String user = System.getProperty("user.name");
        int totalLength = 23;
        int userLength = user.length();
        if (userLength > 10) {
            user = user.substring(0, 10);
        }

        String clientId = user + System.currentTimeMillis();
        Assert.isTrue(clientId.length() <= totalLength);
        return clientId;
    }

    protected MqttConnectOptions buildMqttConnectionOptions() {
        MqttConnectOptions connectOptions = null;
        if (weShouldCreateConnectionOptions()) {
            connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(this.cleanSession);
            connectOptions.setUserName(this.username);
            connectOptions.setPassword(this.password.toCharArray());
        } else if (this.mqttConnectOptions != null) {
            connectOptions = this.mqttConnectOptions;
        }
        return connectOptions;
    }
    
    protected void readProperties(){
        
        Properties properties = new Properties();
       // System.out.println(System.getProperty("user.dir"));
        try {
			properties.load( this.getClass().getClassLoader().getResourceAsStream( "IotClient.properties")) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       // setHost(properties.getProperty("host"));
        setUsername(properties.getProperty("userName"));
        setPassword( properties.getProperty("pwd"));
        setPort( Integer.valueOf(properties.getProperty("port")));
        setCleanSession(true);
        }
}