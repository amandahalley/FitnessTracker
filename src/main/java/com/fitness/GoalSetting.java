package com.fitness;

public class GoalSetting {
    private String goal;
    private boolean goalCompleted;

    //constructor
    public GoalSetting() {
        this.goal = "";
        this.goalCompleted = false;  //sets goal to empty and if its complete false
    }

    public void setGoal(String goal) {
        this.goal = goal;
        this.goalCompleted = false;  //resets for every new goal
    }

    public String getGoal() {
        return goal;
    }

    public void completeGoal(){
        this.goalCompleted = true;  //makes goal completed
    }

    public boolean isGoalCompleted() {
        return goalCompleted;
    }

}
