package org.wisteria.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wisteria.web.APIResult;
import org.wisteria.zk.ConnectionPool;
import org.wisteria.zk.dto.ConnectionDTO;

/**
 * @auther Lei.Liu
 * @create
 * 976157
 * 101.132.115.157:2181
 */
@Controller
@RequestMapping("/zk/connect")
public class ConnectionController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public APIResult<String> connect(String connectString) {
        return APIResult.success(ConnectionPool.createConnection(connectString));
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public APIResult<ConnectionDTO> queryConnection() {
        return APIResult.success();
    }

}