package co.com.accenture.acmsblogapp.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "catchPhrase",
    "bs"
})
@Data
public class Company {

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    
    @JsonProperty("bs")
    private String bs;

}
