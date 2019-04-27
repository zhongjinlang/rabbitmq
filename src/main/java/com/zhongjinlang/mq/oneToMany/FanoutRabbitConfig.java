package com.zhongjinlang.mq.oneToMany;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/27 23:33
 * @description: 广播模式-交换器绑定队列
 */
//@Configuration (测试主题模式下将其注释，否则启动报错 bean的原因)
public class FanoutRabbitConfig {
    // 指定交换器名称
    public static final String EXCHANGE_NAME = "exchange_name";

    // 指定队列名称
    public static final String QUEUQ_ONE_NAME = "queue_one";
    public static final String QUEUQ_TWO_NAME = "queue_two";

    // 创建两个队列
    @Bean
    public Queue queueOne() {
        return new Queue(QUEUQ_ONE_NAME);
    }

    @Bean
    public Queue queueTwo() {
        return new Queue(QUEUQ_TWO_NAME);
    }

    // 交换器
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME);
    }

    // 绑定第一个队列
    @Bean
    public Binding bindingA(Queue queueOne, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueOne).to(fanoutExchange);
    }

    // 绑定第二个队列
    @Bean
    public Binding bindingB(Queue queueTwo, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueTwo).to(fanoutExchange);
    }
}
