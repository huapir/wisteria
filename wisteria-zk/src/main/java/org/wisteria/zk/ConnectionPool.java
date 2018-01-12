package org.wisteria.zk;

import org.apache.zookeeper.ZooKeeper;
import org.wisteria.zk.dto.ConnectionDTO;
import org.wisteria.zk.service.ZNodeWatcher;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther Lei.Liu
 * @create
 */
public class ConnectionPool {
    private static Map<String, ConnectionDTO> connections = new ConcurrentHashMap<String, ConnectionDTO>();

    public static ConnectionDTO getConnection(String connectString) {
        return connections.get(connectString);
    }

    public static String createConnection(String connectString) {
        String key = null;
        int sessionTime = 30000;
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(connectString, sessionTime, new ZNodeWatcher());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (zk != null) {
            key = UUID.randomUUID().toString();
            ConnectionDTO connection = new ConnectionDTO();
            connection.setConnectString(connectString);
            connection.setZk(zk);

            connections.put(key, connection);
        }
        return key;
    }
}
