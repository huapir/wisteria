package org.wisteria.zk.dto;

import org.apache.zookeeper.ZooKeeper;

import java.io.Serializable;

/**
 * @auther Lei.Liu
 * @create
 */
public class ConnectionDTO implements Serializable {

    private static final long serialVersionUID = 2992419091340602316L;

    private String connectString;


    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

}
