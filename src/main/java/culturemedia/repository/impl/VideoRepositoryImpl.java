package culturemedia.repository.impl;
import java.util.ArrayList;
import java.util.List;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;

public class VideoRepositoryImpl implements VideoRepository {

	private final List<Video> videos;

	public VideoRepositoryImpl() {
		videos = new ArrayList<>();
	}

	@Override
	public List<Video> listarTodos() {
		return videos;
	}

	@Override
	public Video agregar(Video video) {
		this.videos.add( video );
		return video;
	}

	@Override
	public List<Video> buscar(String titulo) {
		List<Video> filteredVideos = new ArrayList<>();
		for ( Video video : videos ) {
			if(video.titulo().contains( titulo )){
				if(filteredVideos == null){
					filteredVideos = new ArrayList<Video>();
				}
				filteredVideos.add(video);
			}
		}
		return filteredVideos;
	}

	@Override
	public List<Video> buscar(Double duracionDesde, Double duracionHasta) {
		List<Video> filteredVideos = new ArrayList<Video>();
		for ( Video video : videos ) {
			if(video.duracion()>= duracionDesde && video.duracion()<= duracionHasta){
				filteredVideos.add(video);
			}
		}
		return filteredVideos;
	}

}
