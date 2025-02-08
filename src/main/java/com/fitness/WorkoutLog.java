package com.fitness;

import java.util.ArrayList;
import java.util.List;

public class WorkoutLog {
    private List<Workout> workouts;

    //constructor
    public WorkoutLog() {
        this.workouts= new ArrayList<>();
    }

    //logging workout(includes exercises)
    public void logWorkout(Workout workout) {
        workouts.add(workout);
    }

    //get list of workouts logged
    public List<Workout> getWorkouts() {
        return workouts;
    }
}
