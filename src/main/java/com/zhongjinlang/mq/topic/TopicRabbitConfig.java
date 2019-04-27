package com.zhongjinlang.mq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/28 0:27
 * @description: 主题模式配置
 */
@Configuration
public class TopicRabbitConfig {
    // 指定交换器名称
    public static final String TOP_EXCHANGE = "top_exchange";

    // 指定队列名称
    public static final String QUEUQ_ONE_NAME = "topic.message";
    public static final String QUEUQ_TWO_NAME = "topic.messages";

    // 创建两个队列
    @Bean
    public Queue one() {
        return new Queue(QUEUQ_ONE_NAME);
    }

    @Bean
    public Queue two() {
        return new Queue(QUEUQ_TWO_NAME);
    }

    // 创建一个主题交换器
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(TOP_EXCHANGE);
    }

    // 绑定队列 > 指定字符串匹配发送
    @Bean
    public Binding bindingA(Queue one, TopicExchange exchange) {
        return BindingBuilder.bind(one).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bindingB(Queue two, TopicExchange exchange) {
        return BindingBuilder.bind(two).to(exchange).with("topic.#");
    }
}
