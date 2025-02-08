package com.fitness;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FitnessTrackerTest {

    //testing Exercise class
    @Test
    public void testExercise() {
        Exercise exercise = new Exercise("Shoulder Press", 3, 12, 45);
        assertEquals(3, exercise.getSets());
        assertEquals(12, exercise.getReps());
        assertEquals(45, exercise.getWeight());
    }

    //testing workout class
    @Test
    public void testWorkout() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("Shoulder Press", 3, 12, 45));
        exercises.add(new Exercise("Lateral Raise", 2, 15, 20));
        exercises.add(new Exercise("Rear Delt Fly", 2, 15, 45));

        Workout workout = new Workout("Push Day", "60", "2025-02-02", exercises);

        assertEquals("Push Day", workout.getName());
        assertEquals("60", workout.getTime());
        assertEquals("2025-02-02", workout.getDate());
        assertEquals(3, workout.getExercise().size());
        assertEquals("Shoulder Press", workout.getExercise().getFirst().getName());

    }

    //testing WorkoutLog class
    @Test
    public void testLogWorkout() {
        WorkoutLog workoutLog = new WorkoutLog();
        Workout workout = new Workout("Push Day", "60", "2025-02-02", new ArrayList<>());

        workoutLog.logWorkout(workout);

        assertEquals(1, workoutLog.getWorkouts().size());
        assertEquals("Push Day", workoutLog.getWorkouts().getFirst().getName());
    }
    //testing goalsetting
    @Test
    public void testGoalSetting() {
        GoalSetting goalSetting = new GoalSetting();
        goalSetting.setGoal("Shoulder press 45lbs");

        assertEquals("Shoulder press 45lbs", goalSetting.getGoal());
    }
}


