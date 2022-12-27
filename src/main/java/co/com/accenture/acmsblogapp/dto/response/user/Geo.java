package co.com.accenture.acmsblogapp.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lng"
})
@Data
public class Geo {

    @JsonProperty("lat")
    private String lat;
    
    @JsonProperty("lng")
    private String lng;
    
}
