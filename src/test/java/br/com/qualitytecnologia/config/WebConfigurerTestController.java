package br.com.qualitytecnologia.config;

import br.com.qualitytecnologia.GeneratedByJHipster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@GeneratedByJHipster
public class WebConfigurerTestController {

    @GetMapping("/api/test-cors")
    public void testCorsOnApiPath() {}

    @GetMapping("/test/test-cors")
    public void testCorsOnOtherPath() {}
}
