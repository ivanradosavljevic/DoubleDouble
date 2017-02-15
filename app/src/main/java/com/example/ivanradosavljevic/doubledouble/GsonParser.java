package com.example.ivanradosavljevic.doubledouble;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import util.Post;

/**
 * Created by Ivan Radosavljevic on 10.2.2017.
 */

public class GsonParser {

    static GsonParser instence;

    public static GsonParser getInstance() {
        if (instence == null)
            instence = new GsonParser();
        return instence;
    }

    public List<Post> getFromJson(String text) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Post>>() {}.getType();
        List<Post> list = gson.fromJson(text,collectionType);
        return list;
    }
}
