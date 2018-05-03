package org.wisteria.zk.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @auther Lei.Liu
 * @create
 */
public class GetDataWatcher implements Watcher {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void process(WatchedEvent event) {
        logger.info("GetDataWatcher:事件" + event.getType());
    }
}
