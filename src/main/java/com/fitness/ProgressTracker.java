package com.fitness;

public class ProgressTracker {
    private GoalSetting goal;

    //constructor
    public ProgressTracker(GoalSetting goal, WorkoutLog workoutLog) {
        this.goal = goal;
    }

    public boolean checkProgressOfGoal() {
        return goal.isGoalCompleted();          //confirms if goal is completed
    }

    public void currentGoalCompleted(){         //updates goal as complete
        goal.completeGoal();
    }

    public String getGoal() {
        return goal.getGoal();
    }


}