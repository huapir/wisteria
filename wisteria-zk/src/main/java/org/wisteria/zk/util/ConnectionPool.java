package org.wisteria.zk.util;

import org.apache.zookeeper.ZooKeeper;
import org.wisteria.zk.dto.ZKConnectionDTO;
import org.wisteria.zk.watcher.ZNodeWatcher;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther Lei.Liu
 * @create
 */
public class ConnectionPool {
    private static Map<String, ZKConnectionDTO> connections = new ConcurrentHashMap<String, ZKConnectionDTO>();

    public static ZooKeeper getConnectionZk(String key) {
        ZKConnectionDTO connection = connections.get(key);
        return connection != null ? connection.getZk() : null;
    }

    public static ZKConnectionDTO getConnection(String connectString) {
        ZKConnectionDTO connection = connections.get(connectString);
        return connection;
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
            ZKConnectionDTO connection = new ZKConnectionDTO();
            connection.setConnectString(connectString);
            connection.setZk(zk);

            connections.put(key, connection);
        }
        return key;
    }
}
