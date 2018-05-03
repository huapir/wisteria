package org.wisteria.zk.service;

import java.util.List;

public interface IZKNodeService {

    void create(String key, String path);

    void delete(String key, String path);

    List<String> getChildren(String key, String path);

}
