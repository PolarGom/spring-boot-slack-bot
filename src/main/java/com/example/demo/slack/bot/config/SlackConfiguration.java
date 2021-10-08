package com.example.demo.slack.bot.config;

import com.example.demo.slack.bot.SlackClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(SlackProperties.class)
@ConditionalOnClass(name = "com.example.demo.slack.bot.SlackClient")
@ConditionalOnProperty(prefix = "slack", value = "token")
public class SlackConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SlackClient slackClient(SlackProperties slackProperties) {

        return new SlackClient(slackProperties.getToken());
    }
}
