package jmx;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

public class JmxServer {
    private  JMXConnectorServer cs=null;

    public JmxServer(int rmport, int serverport) {
        try {
            LocateRegistry.createRegistry(rmport);
            JMXServiceURL serviceURL=new JMXServiceURL(
                    String.format("service:jmx:rmi://localhost:%d/jndi/rmi://localhost:%d/jmxrmi",serverport,rmport));
            Map<String,Object> map=new HashMap<>();
            MBeanServer mbs= ManagementFactory.getPlatformMBeanServer();
            this.cs= JMXConnectorServerFactory.newJMXConnectorServer(serviceURL,map,mbs);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
    public void start(){
        try {
            this.cs.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JmxServer(26195,26195).start();
    }
}
