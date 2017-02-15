package util;

import android.util.JsonReader;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Ivan Radosavljevic on 8.2.2017.
 */
public class Post implements Serializable {


    String id;
    String name;
    String author;
    String content;
    String excerpt;
    String thumbnail;

    public Post() {

    }

    public Post(String id, String name, String author, String content, String excerpt, String thumbnail) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.content = content;
        this.excerpt = excerpt;
        this.thumbnail = thumbnail;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
