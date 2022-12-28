package co.com.accenture.acmsblogapp.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.com.accenture.acmsblogapp.dto.response.AlbumDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.CommentDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.PhotoDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.PostDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.UserDTOResponse;

/*name = "ac-ms-pim-rest-typicode"*/
@FeignClient(contextId = "pimRestTypicode", name = "pimRestTypicode", url = "http://localhost:9514/ac-ms-pim-rest-typicode/api")
public interface IPimRestTypicode {

	//User
	@GetMapping(path = "/user")
	public List<UserDTOResponse> getAllUsers();
	
	@GetMapping(path = "/user/{id}")
	public UserDTOResponse getUserById(@PathVariable(name = "id") Integer userId);
	
	@GetMapping(path = "/user/{id}/albums")
	public List<AlbumDTOResponse> getAlbumsByUser(@PathVariable(name = "id") Integer userId);
	
	@GetMapping(path = "/user/{id}/posts")
	public List<PostDTOResponse> getPostByUser(@PathVariable(name = "id") Integer userId);
	
	//Album
	@GetMapping(path = "/album/{id}/photos")
	public List<PhotoDTOResponse> getPhotosByAlbum(@PathVariable(name = "id") Integer userId);
	
	//Posts
	@GetMapping(path = "/post/{id}/comments")
	public List<CommentDTOResponse> getCommentsByPost(@PathVariable(name = "id") Integer postId);
	
}
