package demo.rabbitmq;

import demo.rabbitmq.dto.Email;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static demo.rabbitmq.config.RabbitConfiguration.QUEUE;

@SpringBootApplication
public class RabbitmqDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqDemoApplication.class, args);
	}

	@Autowired
	private RabbitTemplate rabbitTemplate;


	@Override
	public void run(String... args) throws Exception {

		Email email = new Email();
		email.setSubject("123");
		email.setRecipient("123");
		email.setContent("123");

		rabbitTemplate.convertAndSend(QUEUE, email);
	}
}
