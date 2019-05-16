package dong.test;


import dong.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    /**
     * 测试整合spring
     */
    @Test
    public void run1(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取bean对象
        AccountService accountService = ac.getBean("accountService",AccountService.class);

        accountService.findAll();
    }
}
