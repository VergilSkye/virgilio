package br.com.qualitytecnologia;

import br.com.qualitytecnologia.GeneratedByJHipster;
import br.com.qualitytecnologia.VirgilioApp;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = VirgilioApp.class)
public @interface IntegrationTest {
}
