package softuni.gira.web.models;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.gira.data.enums.ClassificationEnum;
import softuni.gira.data.enums.ProgressEnum;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskBindingModel {
    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationEnum classification;
    @NotNull(message = "Name blank cannot be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    @Size(min = 5, message = "Description length must be 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date cannot be in the past")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    @NotNull(message = "You must select classification")
    public ClassificationEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEnum classification) {
        this.classification = classification;
    }
}
