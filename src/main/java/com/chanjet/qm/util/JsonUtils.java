package com.chanjet.qm.util;

import java.lang.reflect.Type;
import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

/**
 */
public class JsonUtils {


    public static String getJsonUTCDateFormat(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new UTCFormatDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(Time.class, new TimeSerializer());
        String result = gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create().toJson(object);
        return result;
    }

    public static String getJsonUTCDateFormatLowerCase(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new UTCFormatDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(Time.class, new TimeSerializer());
        String result = gsonBuilder.setPrettyPrinting().create().toJson(object);
        return result;
    }

    public static String getJsonUTCDateFormatOfExpose(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        gsonBuilder.registerTypeAdapter(Date.class, new UTCFormatDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(Time.class, new TimeSerializer());
        String result = gsonBuilder.setPrettyPrinting().create().toJson(object);
        return result;
    }

    public static  <T> T fromJsonUTCDateFormat(String json, Class<T> classOfT) throws JsonSyntaxException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new UTCFormatDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(Time.class, new TimeSerializer());
        return gsonBuilder.setPrettyPrinting().create().fromJson(json, classOfT);
    }

    public static  <T> T fromJsonUTC_Uper_DateFormat(String json, Type typeOfT) throws JsonSyntaxException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new UTCFormatDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(Time.class, new TimeSerializer());
        return gsonBuilder.setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create().fromJson(json, typeOfT);
    }

    public static  <T> T fromJsonUTCDateFormat(String json, Type typeOfT) throws JsonSyntaxException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new UTCFormatDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(Time.class, new TimeSerializer());
        return gsonBuilder.setPrettyPrinting().create().fromJson(json, typeOfT);
    }

    public static String getJson(Object object){
        String result = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(object);
        return result;
    }

    public static String getUperCaseJson(Object object){
        String result = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(object);
        return result;
    }

    public static String getJsonShortDate(Object object){
        String result = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create().toJson(object);
        return result;
    }

    public static  <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").create().fromJson(json,classOfT);
    }

    public static  <T> T fromJson(String json,Type fooType) throws JsonSyntaxException {
        return new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").create().fromJson(json,fooType);
    }


    public static  <T> T fromJson(JsonElement json, Class<T> classOfT,String dateFormat) throws JsonSyntaxException {
        if (StringUtils.isEmpty(dateFormat)) {
            dateFormat = "yyyy-MM-dd HH:mm:ss";
        }
        return new GsonBuilder().setPrettyPrinting().setDateFormat(dateFormat).create().fromJson(json, classOfT);
    }

    public static class NormalStringSerializer implements JsonSerializer<String>,JsonDeserializer<String>  {
        public JsonElement serialize(final String src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src);
        }

        @Override
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json.getAsString();
        }
    }


    public static class UTCFormatDateTimeSerializer implements JsonSerializer<Date>,JsonDeserializer<Date>  {
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(DateUtils.getUTCString(src));
        }

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return DateUtils.parseDateFromString(json.getAsJsonPrimitive().getAsString(),"yyyy-MM-dd'T'HH:mm:ss.SSS+08:00");
        }
    }

    public static class TimeSerializer implements JsonSerializer<Time>,JsonDeserializer<Time>  {
        public JsonElement serialize(Time src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(DateUtils.get24TimeString(src));
        }

        @Override
        public Time deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return DateUtils.from24TimeString(json.getAsJsonPrimitive().getAsString());
        }
    }

    public  static String  getJson(Object object, final String ...includeFields) {
        ExclusionStrategy myExclusionStrategy = new ExclusionStrategy() {
            @Override   public boolean shouldSkipField(FieldAttributes fa) {
               List<String> includes = Arrays.asList(includeFields);

                return !includes.contains(fa.getName());
            }
            @Override   public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        return new GsonBuilder().setExclusionStrategies(myExclusionStrategy).create().toJson(object);
    }
}
