package org.andino.autumn;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Setter
@Getter
public class Response {

    HttpStatusCode status;

    JsonNode responseBody;

}
