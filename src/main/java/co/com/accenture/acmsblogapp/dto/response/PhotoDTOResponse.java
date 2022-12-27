package co.com.accenture.acmsblogapp.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "albumId", "id", "title", "url", "thumbnailUrl" })
public class PhotoDTOResponse {

	@JsonProperty("albumId")
	private Integer albumId;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("url")
	private String url;

	@JsonProperty("thumbnailUrl")
	private String thumbnailUrl;

}