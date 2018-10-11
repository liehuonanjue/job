


import com.dao.ISaleMapper;
import com.entity.ReplyDetail;
import com.service.IDataCOperationService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class text {

    @Test
    public void text1() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        ISaleMapper bean = context.getBean(ISaleMapper.class);
//        System.out.println(bean.getSaleList("2"));
        System.out.println(bean.getSaleReply("3"));
    }

    @Test
    public void text2() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        IDataCOperationService bean = context.getBean(IDataCOperationService.class);
//        System.out.println(bean.getSaleList("2"));
        System.out.println(bean.DeletePosts(3));
    }

    @Test
    public void text3() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        ReplyDetail replyDetail = new ReplyDetail();
        replyDetail.setInvaid(1);
        replyDetail.setAutohor("1");
        replyDetail.setContent("31");
        IDataCOperationService bean = context.getBean(IDataCOperationService.class);
//        System.out.println(bean.getSaleList("2"));
        System.out.println(bean.AddAReply(replyDetail));
    }


}

