package com.fitness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FitnessTrackerApp {
    private static WorkoutLog workoutLog = new WorkoutLog();
    private static GoalSetting goalSetting = new GoalSetting();
    private static ProgressTracker progressTracker = new ProgressTracker(goalSetting, workoutLog);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //setting up menu of program
        while (true) {
            workoutLogMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    logWorkout();
                    break;
                case 2:
                    viewWorkout();
                    break;
                case 3:
                    setWorkoutGoal();
                    break;
                case 4:
                    checkGoalProgress();
                    break;
                case 5:
                    System.out.println("Thank you for using Workout Logger!");
                    System.out.println("Exiting program..");
                    return;
                default:
                    System.out.println("Invalid option entered, please try again.");
            }
        }

    }

    private static void workoutLogMenu(){
        System.out.println("\nWelcome to Workout Logger!");
        System.out.println("Please choose what you would like to do.");
        System.out.println("1. Log a Workout");
        System.out.println("2. View Your Workouts");
        System.out.println("3. Set a Goal");
        System.out.println("4. Check Your Progress");
        System.out.println("5. Exit Program");
        System.out.println(" ");
        System.out.println("Please choose an option: ");
    }

    //logging a workout
    private static void logWorkout() {

        System.out.println("\nLog a Workout ");
        System.out.print("Enter the name of your workout: ");
        String workoutName = scanner.nextLine();

        System.out.print("Enter duration of workout: ");
        String timeOfWorkout = scanner.nextLine();

        System.out.print("Enter the date: ");
        String date = scanner.nextLine();

        System.out.print("Enter number of exercises: ");
        int numExercises = scanner.nextInt();
        scanner.nextLine();


        //entering individual exercises
        Exercise[] exercises = new Exercise[numExercises];
        for (int i = 0; i < numExercises; i++) {
            System.out.print("Enter exercise " + (i + 1) + " name: ");
            String exerciseName = scanner.nextLine();

            System.out.print("Enter sets: ");
            int sets = scanner.nextInt();

            System.out.print("Enter reps: ");
            int reps = scanner.nextInt();

            System.out.print("Enter weight (lbs): ");
            int weight = scanner.nextInt();
            scanner.nextLine();

            exercises[i] = new Exercise(exerciseName, sets, reps, weight);
        }


        List<Exercise> exerciseList = new ArrayList<>(Arrays.asList(exercises));

        Workout workout = new Workout(workoutName, timeOfWorkout, date, exerciseList);
        workoutLog.logWorkout(workout);
        System.out.println("Workout logged successfully!");
    }

    //viewing logged workouts
    private static void viewWorkout() {
        System.out.println("Viewing Your Workouts");

        if (workoutLog.getWorkouts() == null || workoutLog.getWorkouts().isEmpty()) {
            System.out.println("You currently have no logged workouts.");
            return;
        }

        for (Workout workout : workoutLog.getWorkouts()) {
            System.out.println("\nWorkout: " + workout.getName() + " Date: " + workout.getDate());
            for (Exercise exercise : workout.getExercise()) {
                System.out.println("- " + exercise.getName() + ": sets: " + exercise.getSets() + " reps: " + exercise.getReps() + "(" + exercise.getWeight() + " lbs)");
            }
        }
    }

    //setting workout goal
    private static void setWorkoutGoal() {
        System.out.println("Set Your Workout Goal");

        System.out.println("Enter your goal: ");
        String targetGoal = scanner.nextLine();

        goalSetting.setGoal(targetGoal);
        System.out.println("Goal set to: " + targetGoal);
    }

    //checking goal progress
    private static void checkGoalProgress() {
        System.out.println("Check Your Progress");

        if (progressTracker.checkProgressOfGoal()) {
            System.out.println("You have reached your goal!");
        } else {
            System.out.println("Keep going to reach your goal!");
        }
    }
}
