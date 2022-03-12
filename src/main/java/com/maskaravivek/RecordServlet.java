package com.maskaravivek;

import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Hangup;
import com.twilio.twiml.voice.Record;
import com.twilio.twiml.voice.Say;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recordIncoming")
public class RecordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Say instructions = new Say.Builder("Hello. Please leave a message after the tone and our customer executives will get back to you").build();

        VoiceResponse twiml = new VoiceResponse.Builder()
                .say(instructions)
                .record(new Record.Builder().build())
                .hangup(new Hangup.Builder().build())
                .build();

        response.setContentType("text/xml");

        try {
            response.getWriter().print(twiml.toXml());
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
    }
}