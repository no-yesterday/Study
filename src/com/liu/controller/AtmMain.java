package com.liu.controller;

import com.liu.bean.Manager;
import com.liu.bean.ManagerData;
import com.liu.service.CustomerService;
import com.liu.uitl.TextUitl;

import java.util.List;
import java.util.Scanner;

/**
 * atm取款机入口
 */
public class AtmMain {

    private static String cardid;
    private static String cardpwd;
    private static CustomerService customerService;

    public static void main(String[] args) {
        customerService = new CustomerService();
        //测试管理员类的数据
        ManagerData managerData = ManagerData.getInstance();
        List<Manager> managerList = managerData.getManagerList();
        for (Manager manager : managerList) {
            System.out.println("manager = " + manager);
        }
//        //测试客户类的数据
//        CustomerData customerData = CustomerData.getInstance();
//        List<Customer> customerList = customerData.getCustomerList();
//        for (Customer customer : customerList) {
//            System.out.println("customer = " + customer);
//        }

        //welcome阶段
        TextUitl.welcome();

        //其他操作
        int i = 0;
        //循环，如果超过5次就跳出循环
        while (i<6){
            //输入账号密码阶段
            doWritePassword();
            //校验角色，判断账号密码的正确性
            doCheckPassword(cardid,cardpwd);
            i++;
        }
    }
    //判断身份和检查密码
    private static void doCheckPassword(String cardid,String cardpwd) {
        //先校验身份，判断cardid的长度
        if (cardid.length() == 8) {//卡号8位是客户
            customerService.checkPwd(cardid,cardpwd);
        }
        if (cardid.length() == 2) {//卡号2位是客户

        }
    }
    //输入账号密码
    private static void doWritePassword() {
        Scanner scanner = new Scanner(System.in);
        cardid = scanner.nextLine();
        System.out.println("cardid = " + cardid);
        System.out.println("请输入密码：");
        cardpwd = scanner.nextLine();
        System.out.println("cardpwd = " + cardpwd);
    }

}
