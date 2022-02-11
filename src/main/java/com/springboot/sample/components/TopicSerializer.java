package com.springboot.sample.components;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.springboot.sample.model.Topic;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.SimpleDateFormat;

@JsonComponent
//-- switching off
public class TopicSerializer extends JsonSerializer<Topic> {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    @Override
    public void serialize(Topic topic, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        try {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", String.valueOf(topic.getId()));
            jsonGenerator.writeStringField("name", topic.getName());
            jsonGenerator.writeStringField("start", formatter.format(topic.getStart()));
            jsonGenerator.writeStringField("end", formatter.format(topic.getEnd()));
            jsonGenerator.writeStringField("duration", String.valueOf(((int) topic.getDuration())) + " days");
            jsonGenerator.writeEndObject();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
