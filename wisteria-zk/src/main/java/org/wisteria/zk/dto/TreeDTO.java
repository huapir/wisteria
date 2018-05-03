package org.wisteria.zk.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @auther Lei.Liu
 * @create
 */
public class TreeDTO implements Serializable {

    private static final long serialVersionUID = 7810186825992300871L;

    private int id;
    private String name;
    private List<TreeDTO> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDTO> children) {
        this.children = children;
    }
}
