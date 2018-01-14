package org.wisteria.zk.service;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @auther Lei.Liu
 * @create
 */
public class ZNodeWatcher implements Watcher {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void process(WatchedEvent event) {
        logger.info("触发了" + event.getType() + "事件");
    }

}
