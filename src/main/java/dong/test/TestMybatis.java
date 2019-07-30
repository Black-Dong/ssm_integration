package dong.test;

import dong.dao.AccountDao;
import dong.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    /**
     * 测试查询
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //调用代理对象的方法
        List<Account> list = accountDao.findAll();
        for(Account account : list){
            System.out.println(account);
        }
        //释放资源
        sqlSession.close();
        in.close();

    }

    /**
     * 测试插入
     */
    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("小东");
        account.setMoney(400d);

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //执行代理对象的方法
        accountDao.saveAccount(account);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
        in.close();
    }
}
