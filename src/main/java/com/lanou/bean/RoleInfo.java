package com.lanou.bean;

public class RoleInfo {
    private Integer roleId;

    private String name;

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}