package org.andino.autumn;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@AllArgsConstructor
@Slf4j
public class HttpRequestExecutor {
    final RestTemplate restTemplate;
    final ObjectMapper objectMapper;

    public Response execute(TestCase testCase) {
        log.info("Making a call for {}", testCase.getAct());
        final var httpHeaders = new HttpHeaders();
        return invoke(testCase.getAct(), httpHeaders);
    }

    private Response invoke(TestCase.Act request, MultiValueMap<String, String> headers) {
        HttpEntity<JsonNode> body = new HttpEntity<>(objectMapper.convertValue(request.getBody(),
                JsonNode.class), headers);
        final var exchange = restTemplate.exchange(request.getUri(), request.getMethod(), body, JsonNode.class);
        return new Response(exchange.getStatusCode(), exchange.getBody());
    }
}
