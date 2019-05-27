package test;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 参考网址
 */
//https://www.cnblogs.com/trust-freedom/p/6842332.html
public class FilterPlanMz {
    private  static volatile boolean flag=true;
    private  static int cont=0;
    private static MBeanServer mbs=ManagementFactory.getPlatformMBeanServer();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag){
                    System.out.println("cont="+cont+"flag"+flag);
                    cont++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            mbs.registerMBean(new TestMXBean.TestMXBeanIml(),new ObjectName("bean:name=TestMXBean"));
            Registry registry = LocateRegistry.createRegistry(2000);
            JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:2000/jmxrmi");
            JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, mbs);
            cs.start();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print(String str){
        System.out.println(str+"str");
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        FilterPlanMz.flag = flag;
    }
    public static void setFlag1() {
        FilterPlanMz.flag = false;
    }
    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        FilterPlanMz.cont = cont;
    }
}
