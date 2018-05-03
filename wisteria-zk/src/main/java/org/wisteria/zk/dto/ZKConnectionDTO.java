package org.wisteria.zk.dto;

import org.apache.zookeeper.ZooKeeper;

/**
 * @auther Lei.Liu
 * @create
 */
public class ZKConnectionDTO extends ConnectionDTO {
    private static final long serialVersionUID = 4508515366080903977L;
    private ZooKeeper zk;

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }
}
