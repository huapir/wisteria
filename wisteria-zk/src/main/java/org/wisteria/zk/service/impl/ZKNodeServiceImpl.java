package org.wisteria.zk.service.impl;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.springframework.stereotype.Service;
import org.wisteria.zk.util.ConnectionPool;
import org.wisteria.zk.dto.ZKConnectionDTO;
import org.wisteria.zk.service.IZKNodeService;
import org.wisteria.zk.watcher.GetChildrenWatcher;

import java.util.List;

/**
 * @auther Lei.Liu
 * @create
 */
@Service
public class ZKNodeServiceImpl implements IZKNodeService {

    public void create(String key, String path) {
        ZKConnectionDTO connection = ConnectionPool.getConnection(key);
        try {
            connection.getZk().create(path, path.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(String key, String path) {
        try {
            ConnectionPool.getConnectionZk(key).delete(path, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public List<String> getChildren(String key, String path) {
        List<String> datas = null;
        ZKConnectionDTO connection = ConnectionPool.getConnection(key);
        if (connection != null) {
            try {
                datas = connection.getZk().getChildren(path, new GetChildrenWatcher());
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return datas;
    }
}
