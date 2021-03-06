package com.moody.chat;

import com.moody.chat.health.TemplateHealthCheck;
import com.moody.chat.resources.ConnectionResource;
import com.moody.chat.resources.HelloWorldResource;
import com.moody.chat.resources.MessageResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main (String[] args) throws Exception  {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // TODO 
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(), configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck = 
            new TemplateHealthCheck(configuration.getTemplate());
        final MessageResource messageResource = new MessageResource();
        final ConnectionResource connectionResource = new ConnectionResource();
        environment.jersey().register(connectionResource);
        environment.jersey().register(messageResource);
        environment.jersey().register(resource); 
        environment.healthChecks().register("template", healthCheck);

    }
}
