package uk.ac.ebi.subs.processing.dispatcher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.ac.ebi.subs.messaging.Queues;

/**
 * This configuration class responsible for the RabbitMQ configuration for the dispatcher service.
 */
@Configuration
public class DispatcherQueueConfig {

    /**
     * Queue for submissions to be checked for dispatch to archive agents
     * @return
     */
    @Bean
    Queue dispatcherQueue() {
        return Queues.buildQueueWithDlx(Queues.SUBMISSION_DISPATCHER);
    }

    @Bean
    Binding dispatcherProcessingUpdatedBinding(Queue dispatcherQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(dispatcherQueue).to(submissionExchange).with(Queues.SUBMISSION_PROCESSING_UPDATED_DISPATCHER_ROUTING_KEY);
    }

    /**
     * Queue for submissions to be checked to see if they need supporting info
     * @return
     */
    @Bean Queue onSubmitCheckForSupportingInfoQueue() {return Queues.buildQueueWithDlx(Queues.SUBMISSION_SUBMITTED_CHECK_SUPPORTING_INFO); }


    @Bean
    Binding suppInfoBinding(Queue onSubmitCheckForSupportingInfoQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(onSubmitCheckForSupportingInfoQueue).to(submissionExchange).with(Queues.SUBMISSION_SUBMITTED_ROUTING_KEY);
    }
}
