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
                //取款
                goGetMoneyHome();
                goOneHome();
                break;
            case "3":
                doTruanMoney();
                goOneHome();
                break;
            case "4":
                doSaveMoney();
                goOneHome();
                break;
            case "5":
                doQuitCard();
                goOneHome();
                break;
        }
    }

    private void doQuitCard() {
        //退卡
        System.out.println("是否确定退卡yes/no[Y/N]");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("y")) {
            TextUitl.welcome();
        }
        if (s.equalsIgnoreCase("n")) {
            TextUitl.oneLeveOption();
        }
    }

    private void doSaveMoney() {
        //存款
        //1.提示界面
        System.out.println("请输入你要存的钱数：");
        //2.scanner 接收钱数
        Scanner scanner = new Scanner(System.in);
        String moneyIn = scanner.nextLine();
        Double moneyInInt = Double.valueOf(moneyIn);
        double newMoney = currentCustomer.getMoney()+moneyInInt;//ctrl + alt + v 快速返回数据类型
        //更新当前用户的余额
        currentCustomer.setMoney(newMoney);
        System.out.println("您的账户余额是：" + newMoney);
    }


    private void doTruanMoney() {//转账的方法
        System.out.println("输入对方账号：");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("输入转账金额：");
        String otherMoney = scanner.nextLine();
        //计算，自己的钱 - otherMoney ，别人的钱 + otherMoney
        Double otherMoneyInt = Double.parseDouble(otherMoney);
        double currentMoney = currentCustomer.getMoney()-otherMoneyInt;//自己被减去otherMoney后的钱
        //别人加钱 根据别人的账户查询出别人的余额，查出别人的余额后，修改别人的余额
        //因为所有人都在cuntomerList这个集合中，那么遍历这个集合
        Customer other = null;
        for (Customer customer : customerList) {
            //如果customer.getAcount等于otherAcount，那么这个人就选出来了
            if (customer.getAccount().equals(otherAccount)) {
                other = customer;
            }
        }
        double otherOneMoney = other.getMoney()+otherMoneyInt;//别人的余额

        //自己和别人都更新一下钱数
        currentCustomer.setMoney(currentMoney);
        other.setMoney(otherOneMoney);//注意，有问题，不能创建对象了
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
    private void goGetMoneyHome(){
        TextUitl.getMoneyUI();
        // 1. 让客户输入
        Scanner scanner = new Scanner(System.in);
        String  numIn = scanner.nextLine();
        if (numIn.equals("1")){
            // 那么 取款100 那么就应该 让 顾客的 钱 -100
            double money = currentCustomer.getMoney();
            money=money-100;
            System.out.println("您的余额是: " + money);
            // 取完款项之后,  更新 原有的 存款
            currentCustomer.setMoney(money);
        }
    }

}
