package org.wisteria.zk.dto;

import org.apache.zookeeper.ZooKeeper;

import java.io.Serializable;

/**
 * @auther Lei.Liu
 * @create
 */
public class ConnectionDTO implements Serializable {

    private String connectString;
    private ZooKeeper zk;

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }
}
