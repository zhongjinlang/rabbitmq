package com.zhongjinlang.mq.oneToOne;

import com.zhongjinlang.mq.oneToOne.RabbitMQConfig;
import com.zhongjinlang.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/27 22:37
 * @description:
 */

@Slf4j
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
public class Consumer {

    @RabbitHandler
    public void handlerMsg(User user){
        log.info("消费的信息为: {}", user.toString());
    }
}
