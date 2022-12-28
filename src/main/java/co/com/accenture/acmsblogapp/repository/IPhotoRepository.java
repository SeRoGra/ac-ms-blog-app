package co.com.accenture.acmsblogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.accenture.acmsblogapp.entity.Photo;

@Repository
public interface IPhotoRepository extends JpaRepository<Photo, Long>{
	
	List<Photo> findByAlbumIdAndPhotoApiIdIsNull(Long albumId);
	
}
