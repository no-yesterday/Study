package com.liu.bean;

import java.util.ArrayList;
import java.util.List;

public class ManagerData {
    private static ManagerData ourInstance = new ManagerData();
    private List<Manager> managerList;

    public static ManagerData getInstance() {
        return ourInstance;
    }

    private ManagerData() {
        managerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Manager manager = new Manager();
            manager.setAccount("1"+i);
            manager.setPassword("123");
            manager.setMname("管理员"+i+"号");

            managerList.add(manager);
        }
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }
}
