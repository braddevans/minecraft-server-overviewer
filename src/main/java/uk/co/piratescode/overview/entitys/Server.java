package uk.co.piratescode.overview.entitys;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;

public class Server {
    private int listID;
    private String serverName;
    private String hostName;
    private int port;
    private boolean islocal;

    public Server(int id, String _serverName, String hostname, int _port, boolean local) {
        try {
            listID = id;
            serverName = _serverName;
            port = _port;

            if (!local) {
                hostName = hostname;
                islocal = false;
            } else {
                hostName = "";
                islocal = true;
            }
        } catch (Exception ignored) {
        }
    }

    public boolean isIslocal() {
        return islocal;
    }

    public void setIslocal(boolean local) {
        islocal = local;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostname) {
        hostName = hostname;
    }

    public MBeanServerConnection getConnection() throws MalformedURLException {
        JMXServiceURL url;
        JMXConnector jmxc;
        MBeanServerConnection mbsc = null;

        try {
            url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
            jmxc = JMXConnectorFactory.connect(url, null);
            mbsc = jmxc.getMBeanServerConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mbsc;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String servername) {
        serverName = servername;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int ID) {
        listID = ID;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int _port) {
        port = _port;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
