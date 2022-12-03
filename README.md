#  Spring Boot Skeleton

A simple spring boot skeleton to get going with less hassle.

## RabbitMQ
RabbitMQ is a message broker. A message broker is software that enables applications, systems, and services to communicate with each other and exchange information. The message broker does this by translating messages between formal messaging protocols. This allows interdependent services to “talk” with one another directly, even if they were written in different languages or implemented on different platforms.
[source](https://www.ibm.com/cloud/learn/message-brokers)

![rabbitmq-image](https://user-images.githubusercontent.com/16105008/205456042-31426647-8c1a-49e1-a9b5-ef9709e4e68c.png)

### 5 Types of Exchange

* Direct: The  producer will create the message with routing key. so with direct exchange the routing key is being compared to the binding key, if its an exact match then message will move through the system.

* Fanout: The producer will pass the message to the exchange and the exchange will duplicate the message and send t to every sngle queue that it knows about.

* Topic: With a topic exchange we can do a partial match between the routing key and the binding key. if we had a routing key on the message called "ship.shoes" and the binding key was called "ship.any" and the exchange type was a topic exchange. the message would get routed through that queue.

* Header: With a header exchange the routing key is ignored completely and the message is moved through the system according to the header.

* Default: Default exchange is qunique only to RabbitMQ. it is not part of AMQP protocol. It is also called nameless exchange. In thi exchange the routing key is getting tied to the name of the queue itself.

### RabbitMQ Basic Setup

* first add the spring-amqp and spring-rabbit dependecy in the project.

```
<!-- https://mvnrepository.com/artifact/org.springframework.amqp/spring-amqp -->
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-amqp</artifactId>
            <version>2.4.7</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework.amqp/spring-rabbit -->
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-rabbit</artifactId>
            <version>2.4.7</version>
        </dependency>
```

* Second start configure the rabbitmq. for that we need to create couple of beans. here i have used topic exchange, it can be replaced with any other exchange that goes with your business logic.

```
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "message_queue";
    public static final String exchange = "message_exchange";
    public static final String BINDING_KEY = "message_binding_key";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(BINDING_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}

```

* Now send any message to the rabbitmq.

```
@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/info")
    public void getTest() {

        CustomMessage message = new CustomMessage();
        message.setMessage("hello world, time is "+ (new Date()).toString() );
        rabbitTemplate.convertAndSend(RabbitMQConfig.exchange, RabbitMQConfig.BINDING_KEY, message);
    }
}
```
* As we are using spring boot framework, it will add these below properties for us. if we want to modify any of these properties we can add them in application-properties files.
```
#RabbitMQ settings
rabbitmq.host=localhost
rabbitmq.port=15672
rabbitmq.username=guest
rabbitmq.password=guest
```

## License

This project is licensed under the [prodhan29] License - see the LICENSE.md file for details
