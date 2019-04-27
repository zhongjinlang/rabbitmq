package com.zhongjinlang.mq.topic;

import com.zhongjinlang.mq.oneToMany.FanoutRabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/28 0:01
 * @description:
 */
@Component
@RabbitListener(queues = TopicRabbitConfig.QUEUQ_TWO_NAME)
@Slf4j
public class TopicConsumerTwo {

    @RabbitHandler
    public void showMessage(String message){
        log.info("Two-messages队列信息: {}", message);
    }
}
