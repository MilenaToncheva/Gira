package softuni.gira.data.entities;

import softuni.gira.data.enums.ClassificationEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "classifications")
public class ClassificationEntity extends BaseEntity {
    private ClassificationEnum classificationName;
    private String Description;

    @Column
    public ClassificationEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationEnum classificationName) {
        this.classificationName = classificationName;
    }

    @Column(nullable = false)
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
