package co.com.accenture.acmsblogapp.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"userId",
"id",
"title"
})
@Data
public class AlbumDTOResponse {
	
	@JsonProperty("userId")
	private Integer userId;
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("title")
	private String title;

}
