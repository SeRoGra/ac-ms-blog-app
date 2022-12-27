package co.com.accenture.acmsblogapp.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "street",
    "suite",
    "city",
    "zipcode",
    "geo"
})
@Data
public class Address {

    @JsonProperty("street")
    private String street;
    
    @JsonProperty("suite")
    private String suite;
    
    @JsonProperty("city")
    private String city;
    
    @JsonProperty("zipcode")
    private String zipcode;
    
    @JsonProperty("geo")
    private Geo geo;

}
