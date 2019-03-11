package com.example.yinshengnan.suting_a.sn.showUtil;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;

/**
 * File: org.rubik.commonlib.util.JsonUtils.java
 * Description: xxx
 *
 * @author Done
 * @date 2019/1/30
 */

public class JsonUtils {
    private static Gson mGson;

    public static void testJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            Iterator<String> keys = jsonObject.keys();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static Object toObject(String sourceJson, Class<?> objClass) {
        if (!TextUtils.isEmpty(sourceJson)) {
            if (mGson == null) {
                mGson = new GsonBuilder().registerTypeAdapter(String.class, new NullStringToEmptyAdapterFactory()).create();
            }
            Object ret = null;
            try {
                ret = mGson.fromJson(sourceJson, objClass);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ret;
        } else {
            return null;
        }
    }

    public static String toJson(Object obj) {
        if (obj != null) {
            if (mGson == null) {
                mGson = new GsonBuilder().registerTypeAdapter(String.class, new NullStringToEmptyAdapterFactory()).create();
            }
            String json = "";
            try {
                json = mGson.toJson(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        } else {
            return "";
        }
    }

    private static class NullStringToEmptyAdapterFactory<T> implements JsonSerializer<String> {


        @Override
        public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null || src.equals("null") ? new JsonPrimitive("") : new JsonPrimitive(src.toString());
        }
    }

    private static class StringNullAdapter extends TypeAdapter<String> {

        @Override
        public void write(JsonWriter out, String value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.value(value);
        }

        @Override
        public String read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return "";
            }
            return in.nextString();
        }
    }
}
