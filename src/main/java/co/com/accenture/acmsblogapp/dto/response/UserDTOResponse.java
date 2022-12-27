package co.com.accenture.acmsblogapp.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import co.com.accenture.acmsblogapp.dto.response.user.Address;
import co.com.accenture.acmsblogapp.dto.response.user.Company;
import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "username",
    "email",
    "address",
    "phone",
    "website",
    "company"
})
@Data
@ToString
public class UserDTOResponse {

    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("address")
    private Address address;
    
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("website")
    private String website;
    
    @JsonProperty("company")
    private Company company;

}
