package com.zhongjinlang.mq.oneToOne;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/27 22:25
 * @description:
 */
@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "direct_name";

    // 指定队列名称和是否持久化
    @Bean
    public Queue directQueue(){
        return new Queue(QUEUE_NAME, true);
    }
}
