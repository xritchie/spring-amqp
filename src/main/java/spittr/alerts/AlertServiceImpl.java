package spittr.alerts;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import spittr.domain.Spittle;

/**
 * Created by shawnritchie on 16/04/15.
 */
public class AlertServiceImpl implements AlertService{

    private RabbitTemplate rabbit;

    @Autowired
    public AlertServiceImpl(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

//    public void sendSpittleAlert(Spittle spittle) {
//        rabbit.convertAndSend("spittle.alert.exchange",
//                "spittle.alerts",
//                spittle);
//    }

    public void sendSpittleAlert(Spittle spittle) {
        rabbit.send(
            "spittle.alert.exchange",
            "spittle.alerts",
            MessageBuilder
                .withBody(SerializationUtils.serialize(spittle))
                .setHeader("test", "test")
                .build()
        );
    }
}
