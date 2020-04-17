
import com.tensquare.rabbitmq.RabbitDemoAppliaton;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/*
 * @Description: MqTest
 * @Author: Mr. Jf
 * @Time: 2020/4/13 22:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitDemoAppliaton.class)
public class MqTest {
  @Autowired
  private RabbitTemplate rabbitTemplate;
  
  @Test
  public void testSend() {
    rabbitTemplate.convertAndSend("itcast", "直接模式 test");
  }
  
  @Test
  public void testSend2() {
    rabbitTemplate.convertAndSend("chuanzhi","", "分裂模式测试");
  }
  
  @Test
  public void testSend3() {
    rabbitTemplate.convertAndSend("topic84","good.sth", "主题模式测试");
  }
  
  @Test
  public void testSend4() {
    rabbitTemplate.convertAndSend("topic84","sth.log", "主题模式测试");
  }
  
  @Test
  public void testSend5() {
    rabbitTemplate.convertAndSend("topic84","good.log", "主题模式");
  }
}
