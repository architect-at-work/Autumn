package org.andino.autumn;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class AutumnApplicationTests {

    private final HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutor(new RestTemplate(), new ObjectMapper());
    private final YamlReader yamlReader = new YamlReader();

    @TestFactory
    public Collection<DynamicTest> runAllTestCasesInResources() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:*.yml");

        return Stream.of(resources)
                .parallel()
                .map(resource -> dynamicTest(resource.getFilename(), () -> {
                    TestCase testCase = yamlReader.readYamlFile(resource.getFilename());

                    Response response = httpRequestExecutor.execute(testCase);


                    assertThatJson(response.getResponseBody())
                            .when(IGNORING_EXTRA_FIELDS)
                            .isEqualTo(testCase.getAsserts().getBody());
                })).toList();
    }

}