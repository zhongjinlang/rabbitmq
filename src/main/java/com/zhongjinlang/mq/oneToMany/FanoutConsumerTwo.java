package com.zhongjinlang.mq.oneToMany;

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
@RabbitListener(queues = FanoutRabbitConfig.QUEUQ_TWO_NAME)
@Slf4j
public class FanoutConsumerTwo {

    @RabbitHandler
    public void showMessage(String message){
        log.info("Two队列监听到消息: {}", message);
    }
}
