package softuni.gira;

import org.springframework.boot.CommandLineRunner;
import softuni.gira.service.ClassificationService;

public class GiraApplicationInit implements CommandLineRunner {
    private final ClassificationService classificationService;

    public GiraApplicationInit(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.classificationService.loadClassifications();
    }
}
