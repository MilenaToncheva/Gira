package softuni.gira.service.models;

import softuni.gira.data.enums.ClassificationEnum;

public class ClassificationServiceModel {
    private String id;
    private ClassificationEnum classificationName;
    private String Description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClassificationEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationEnum classificationName) {
        this.classificationName = classificationName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
