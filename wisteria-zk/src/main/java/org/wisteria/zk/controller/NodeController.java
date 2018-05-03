package org.wisteria.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wisteria.web.APIResult;
import org.wisteria.zk.dto.TreeDTO;
import org.wisteria.zk.service.IZKNodeService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther Lei.Liu
 * @create
 */
@Controller
@RequestMapping("/zk/node")
public class NodeController {

    @Resource
    private IZKNodeService zkNodeService;

    @RequestMapping(value = "/node/children", method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<TreeDTO>> getChildren(String key, String path) {
        List<TreeDTO> datas = null;
        if (StringUtils.hasText(path)) {
            datas = getChildrenByZK(key, path);
        } else {
            datas = getRootChildren(key);
        }
        return APIResult.success(datas);
    }

    @RequestMapping(value = "/node", method = RequestMethod.POST)
    @ResponseBody
    public APIResult<Object> create(String key, String path) {
        zkNodeService.create(key, path);
        return APIResult.success();
    }

    @RequestMapping(value = "/node", method = RequestMethod.DELETE)
    @ResponseBody
    public APIResult<Object> remove(String key, String path) {
        zkNodeService.delete(key, path);
        return APIResult.success();
    }

    private List<TreeDTO> getRootChildren(String key) {
        String path = "/";
        List<TreeDTO> datas = new ArrayList<TreeDTO>();
        TreeDTO dto = new TreeDTO();
        dto.setName(path);
        dto.setChildren(getChildrenByZK(key, path));
        return datas;
    }

    private List<TreeDTO> getChildrenByZK(String key, String path) {
        List<TreeDTO> datas = new ArrayList<TreeDTO>();
        List<String> childrens = zkNodeService.getChildren(key, path);
        if (!CollectionUtils.isEmpty(childrens)) {
            TreeDTO dto = null;
            for (String str : childrens) {
                dto = new TreeDTO();
                dto.setName(str);
                datas.add(dto);
            }
        }
        return datas;
    }

}
