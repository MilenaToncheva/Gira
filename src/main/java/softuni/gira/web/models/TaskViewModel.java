package softuni.gira.web.models;

import softuni.gira.data.entities.ClassificationEntity;
import softuni.gira.data.entities.UserEntity;
import softuni.gira.data.enums.ClassificationEnum;
import softuni.gira.data.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskViewModel {
    private String id;
    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private ClassificationEnum classification;
    private String assignedTo;

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

    public ClassificationEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEnum classification) {
        this.classification = classification;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
