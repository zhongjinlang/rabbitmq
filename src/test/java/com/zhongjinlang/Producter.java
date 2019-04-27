package com.zhongjinlang;
import com.zhongjinlang.mq.oneToMany.FanoutRabbitConfig;
import com.zhongjinlang.mq.oneToOne.RabbitMQConfig;
import com.zhongjinlang.mq.topic.TopicRabbitConfig;
import com.zhongjinlang.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/27 22:37
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Producter {
    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @Test
    public void senMsg(){
        // 指定要发送的队列和数据
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, new User(2, "lisi", "1234"));
    }

    @Test
    public void senMsgToMany(){
        // 发送消息到交换器即可，它会负责转发到指定的队列
        rabbitTemplate.convertAndSend(FanoutRabbitConfig.EXCHANGE_NAME, "", "hello world");
    }

    @Test
    public void sendTopic_Message(){
        // 主题1（匹配单个）
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TOP_EXCHANGE,  "topic.12313","i am message one");
    }

    @Test
    public void sendTopic_Messages(){
        // 主题2（匹配多个）
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TOP_EXCHANGE, "topic.message", "i am message two");
    }
}
