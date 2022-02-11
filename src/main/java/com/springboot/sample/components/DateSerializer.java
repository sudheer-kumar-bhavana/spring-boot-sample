package com.springboot.sample.components;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonComponent
public class DateSerializer extends JsonSerializer<Date> {


    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //jsonGenerator.writeStartObject(); //no need of this
        //System.out.println("In DateSerializer "+date);

        try {
            jsonGenerator.writeString(new SimpleDateFormat("dd-MMM-yyyy").format(date));
        }catch (Exception e){
            e.printStackTrace();
        }
        //jsonGenerator.writeEndObject();
    }
}
