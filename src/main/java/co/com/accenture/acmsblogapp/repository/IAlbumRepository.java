package co.com.accenture.acmsblogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.accenture.acmsblogapp.entity.Album;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, Long>{
	
	List<Album> findByUserIdAndAlbumApiIdIsNull(Long userId);

}
