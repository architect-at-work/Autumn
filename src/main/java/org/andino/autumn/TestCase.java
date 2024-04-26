package org.andino.autumn;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpMethod;

import java.net.URI;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestCase {
    private Act act;
    private Assert asserts;

    @AllArgsConstructor
    @Setter
    @Getter
    @NoArgsConstructor
    public static class Act {
        private String url;
        private HttpMethod method;
        private JsonNode body;

        public URI getUri() {
            return URI.create(url);
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Assert {
        private int status;
        private JsonNode body;
    }
}
