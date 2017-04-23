package com.company.ccet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

import javax.inject.Inject;

@RestController
@RequestMapping("/twilio")
public class TwilioWebHookController {


    @RequestMapping(path = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
    public void callback(HttpServletRequest request, HttpServletResponse response) {

        Message sms = createMessage("The Robots are coming! Head for the hills!");
        MessagingResponse twiml = createMessagingResponse(sms);

        response.setContentType("application/xml");

        try {
            response.getWriter().print(twiml.toXml());
        } catch (TwiMLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private MessagingResponse createMessagingResponse(Message sms) {
        return new MessagingResponse.Builder().message(sms).build();
    }

    private Message createMessage(String messageBody) {
        return new Message.Builder().body(new Body(messageBody)).build();
    }
}