package org.wisteria.zk.controller;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wisteria.web.APIResult;
import org.wisteria.zk.ConnectionPool;
import org.wisteria.zk.dto.ConnectionDTO;
import org.wisteria.zk.service.ZNodeWatcher;

import java.io.IOException;
import java.util.List;

/**
 * @auther Lei.Liu
 * @create
 */
@Controller
@RequestMapping("/zk")
public class ConnectionController {

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    @ResponseBody
    public APIResult<String> connect(String connectString) {
        return APIResult.success(ConnectionPool.createConnection(connectString));
    }

    @RequestMapping(value = "/node/children", method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<String>> getChildren(String key, String path) {
        List<String> datas = null;
        ConnectionDTO connection = ConnectionPool.getConnection(key);
        if (connection != null) {
            try {
                datas = connection.getZk().getChildren(path, false);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return APIResult.success(datas);
    }

    @RequestMapping(value = "/node", method = RequestMethod.POST)
    @ResponseBody
    public APIResult<Object> create(String key, String path) {
        ConnectionDTO connection = ConnectionPool.getConnection(key);
        return APIResult.success();
    }
}