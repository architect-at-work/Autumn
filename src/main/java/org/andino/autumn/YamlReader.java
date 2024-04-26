package org.andino.autumn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.LoaderOptions;

import java.io.IOException;
import java.io.InputStream;

public class YamlReader {
    public TestCase readYamlFile(String fileName) {
        LoaderOptions loadingConfig = new LoaderOptions();
        loadingConfig.setAllowDuplicateKeys(true);
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        try {
            return om.readValue(inputStream, TestCase.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
