package me.hadji.managers;

import me.hadji.model.Student;
import me.hadji.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainerManager {
    private List<Trainer> trainers;
    public int trainerIDSequence=100;
    public TrainerManager(){
        this.trainers = new ArrayList<>();
    }
    public List<Trainer> getTrainers(){
        return trainers;
    }
    public void addTrainer(Trainer trainer) {
        /* Every time i create a new trainer i increase the ID by one, initial value 100*/
        trainer.setTrainerId(++trainerIDSequence);
        trainers.add(trainer);
        System.out.println("Trainer added: " + trainer.toString());
    }
}
