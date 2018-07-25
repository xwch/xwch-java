package com.xwch.base;

import com.xwch.base.bean.AddressDAO;
import com.xwch.base.bean.UserDAO;
import com.xwch.base.dao.UserDAOMapper;
import com.xwch.base.service.AddressManager;
import com.xwch.base.service.UserManager;
import org.junit.Test;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xwch on 2017/5/15.
 */

public class UserManagerTest extends BaseTest {

    @Resource
    UserManager userManager;
    @Autowired
    AddressManager addressManager;

    @Autowired
    private UserDAOMapper userDAOMapper;


    @Test
    public void queryTest(){
        AddressDAO addressDAO = addressManager.queryAddressInfoByReceiver("张翠山");
        System.out.println("list--->"+addressDAO.toString());
    }


    @Autowired
    private MyBatisCursorItemReader myMyBatisCursorItemReader;
    @Test
    public void queryByNameTest(){
        try{

            Map<String,Object> paramsMap = new HashMap<>();
            //查询的sql所3需要的参数
            paramsMap.put("userName","谢伟昌");
            //设置参数
            myMyBatisCursorItemReader.setParameterValues(paramsMap);
            myMyBatisCursorItemReader.setQueryId("com.xwch.base.dao.UserDAOMapper.getList");

            //打开
            myMyBatisCursorItemReader.open(new ExecutionContext());
            List<UserDAO> smallChunk = new ArrayList<>();
            UserDAO employee;
            while ((employee= (UserDAO) myMyBatisCursorItemReader.read())!=null) {
                smallChunk.add(employee);
                if (smallChunk.size()==10){
                    System.out.println("处理-->"+smallChunk.size());
                    smallChunk.clear();
                }
                //doSomethingWithAlreadyFetchedEmployees(smallChunk);
            }
            System.out.println("处理-->"+smallChunk.size());
        }catch(Exception e){
            System.out.println(e);
            //do some
        }finally{
            myMyBatisCursorItemReader.close();
        }
/*        List<UserDAO> list = userManager.queryUserByUserName("谢伟昌");
        System.out.println("list--->"+list.toString());*/
    }

    @Test
    public void test(){
        String s = "xie||chang|";
        String []strings = s.split("\\|");
        System.out.println("strings--->"+ Arrays.toString(strings));
        System.out.println("strings.length-->"+strings.length);
    }

    /**
     * 获取2个时间间隔的天数
     * @throws ParseException
     */
    @Test
    public void getDelayDays() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(new Date());
        System.out.println("today--->"+today);

        Date endDate = sdf.parse("20180301");
        System.out.println("endDate--->"+endDate.toString());
        //getTime 是毫秒级的
        long count = (endDate.getTime()-new Date().getTime())/(24*60*60*1000);
        System.out.println("剩下天数--->"+count);
    }



}
