package softuni.gira.service.models;

import softuni.gira.data.entities.ClassificationEntity;
import softuni.gira.data.entities.UserEntity;
import softuni.gira.data.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskServiceModel {
    private String id;
    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private ClassificationServiceModel classification;
    private UserServiceModel user;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ClassificationServiceModel getClassification() {
        return classification;
    }

    public void setClassification(ClassificationServiceModel classification) {
        this.classification = classification;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }
}
