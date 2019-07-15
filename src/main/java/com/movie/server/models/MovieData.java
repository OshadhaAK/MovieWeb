package com.movie.server.models;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MovieData {
    public String _id;
    public String name;
    public int year;
    public String genre;
    public List<Actor> actors;
    public String description;
    public String link;


    public MovieData() {
    }

    public MovieData(String _id, String name, int year, String genre, List<Actor> actors, String description, String link) {
        this._id = _id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.actors = actors;
        this.description = description;
        this.link = link;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
