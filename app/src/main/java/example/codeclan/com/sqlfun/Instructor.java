package example.codeclan.com.sqlfun;

import java.io.Serializable;

/**
 * Created by user on 06/07/2017.
 */

public class Instructor implements Serializable {

    private int _id;
    private String name;
    private String favourite_language;

    public Instructor(){

    }

    public Instructor (int id, String name, String favourite_language){
        this._id = id;
        this.name = name;
        this.favourite_language = favourite_language;
    }

    public Instructor (String name, String favourite_language){
        this.name = name;
        this.favourite_language = favourite_language;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavourite_language() {
        return favourite_language;
    }

    public void setFavourite_language(String favourite_language) {
        this.favourite_language = favourite_language;
    }
}













