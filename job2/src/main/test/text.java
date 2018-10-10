


import com.dao.ISaleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {

    @Test
    public void text1() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        ISaleMapper bean = context.getBean(ISaleMapper.class);
        System.out.println(bean.getSaleList("2"));
        System.out.println(bean.getSaleReply("3"));
    }



}

