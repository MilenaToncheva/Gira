package softuni.gira.web.models;

import softuni.gira.data.enums.ClassificationEnum;
import softuni.gira.data.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskBindingModel {
    private String id;
    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private ClassificationEnum classification;
}
