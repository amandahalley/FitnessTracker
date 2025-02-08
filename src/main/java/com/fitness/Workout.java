package com.fitness;

import java.util.Collections;
import java.util.List;

public class Workout {
    private String name;
    private String time;
    private String date;
    private List<Exercise> exercises;

    //constructor
    public Workout(String name, String time, String date, List<Exercise> exercises) {
        this.name = name;
        this.time = time;
        this.date = date;
        this.exercises = exercises;
    }

    //getters
    public String getName() {
        return name;
    }
    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public List<Exercise> getExercise() {

        return Collections.unmodifiableList(exercises);
    }

}