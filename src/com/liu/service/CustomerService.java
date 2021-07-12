package com.liu.service;

import com.liu.bean.Customer;
import com.liu.bean.CustomerData;
import com.liu.uitl.TextUitl;

import java.util.List;
import java.util.Scanner;

//此类是完成客户的所有业务（增删改查）
public class CustomerService {
    private List<Customer> customerList;
    private Customer currentCustomer;//当前的customer
    //1.查，登录，判断账号密码是否正确
    public void checkPwd(String cardid,String cardpwd){
        //测试客户类的数据
        CustomerData customerData = CustomerData.getInstance();
        customerList = customerData.getCustomerList();
        //拿到cardid中的账户名和密码 与list中的数据对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardpwd = " + cardpwd);

        for (Customer customer : customerList) {
            //校验账号和密码
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardpwd)){
                currentCustomer = customer;
                System.out.println("欢迎"+customer.getCname()+"使用atm取款机，请注意安全");
                TextUitl.oneLeveOption();//一级选择界面
                //输入
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
            }
        }
    }

    private void oneOption(String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                //查询余额
                doSelectMoney();
                //查询完余额后 回退到一级选项中
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                goOneHome();
                break;
        }
    }

    private void doSelectMoney() {
        //查询余额
        double money = currentCustomer.getMoney();
        System.out.println("余额是 " + money);
    }

    private void goOneHome(){
        TextUitl.oneLeveOption();//界面
        //再次输入 获取
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option = " + option);
        oneOption(option);
    }
}
