package dong.controller;

import dong.domain.Account;
import dong.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * web层:控制器
 */
@Controller()
@RequestMapping("/account")
public class AccountController {

    //整合spring:能调用service层就算
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    private String findAll(Model model){
        //测试springMVC是否搭建完成
        System.out.println("表现层:查询所有账户...");

        //调用service层就算
        List<Account> list = accountService.findAll();

        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/save")
    public String save(Account account){
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }
}
