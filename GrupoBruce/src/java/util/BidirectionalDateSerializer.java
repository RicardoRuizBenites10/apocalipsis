/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author RICARDO
 */
public class BidirectionalDateSerializer implements JsonSerializer<Date>, JsonDeserializer<Date>{
    
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public JsonElement serialize(Date t, Type type, JsonSerializationContext jsc) {
        return new JsonPrimitive(format.format(t));
    }

    @Override
    public Date deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        try {
//            return (Date) format.parse(je.getAsJsonPrimitive().getAsString()); //util.date
            return new java.sql.Date(format.parse(je.getAsJsonPrimitive().getAsString()).getTime()); // sql.date
        } catch (ParseException ex) {
            throw new JsonParseException("Error: " + ex.getMessage());
        }
    }
    
}
