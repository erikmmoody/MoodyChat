package com.moody.chat.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.codahale.metrics.annotation.Timed;
import com.moody.chat.api.Message;

@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
    private final AtomicLong counter;

    public MessageResource() {
        this.counter = new AtomicLong();
    }

    @POST
    @Timed
    public Response receiveMessage(Message message) {
        final String recipient = message.getRecipient();
        final String sender = message.getSender();
        return Response.status(Response.Status.OK)
            .entity(String.format("Message from %s sent to %s",
                sender, recipient))
            .build();  
    }
}
