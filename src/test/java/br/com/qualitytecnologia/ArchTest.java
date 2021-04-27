package br.com.qualitytecnologia;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import br.com.qualitytecnologia.GeneratedByJHipster;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

@GeneratedByJHipster
class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("br.com.qualitytecnologia");

        noClasses()
            .that()
            .resideInAnyPackage("br.com.qualitytecnologia.service..")
            .or()
            .resideInAnyPackage("br.com.qualitytecnologia.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..br.com.qualitytecnologia.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
