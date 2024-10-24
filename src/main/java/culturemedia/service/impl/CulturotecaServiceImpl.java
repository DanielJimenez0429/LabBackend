package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Reproduccion;
import culturemedia.model.Video;
import culturemedia.service.CulturotecaService;
import culturemedia.repository.ReproduccionRepository;
import culturemedia.repository.VideoRepository;

import java.util.List;

public class CulturotecaServiceImpl implements CulturotecaService{
    public VideoRepository videoRepository;
    public ReproduccionRepository reproduccionRepository;

    public CulturotecaServiceImpl(VideoRepository videoRepository, ReproduccionRepository reproduccionRepository) {
        this.videoRepository = videoRepository;
        this.reproduccionRepository = reproduccionRepository;
    }


    @Override
    public List<Video> listarTodos() throws VideoNotFoundException {
        List<Video> videos = videoRepository.listarTodos();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        } else {
            return videos;
        }
    }

    @Override
    public Video agregar(Video video) {
        videoRepository.agregar(video);
        return video;
    }


    @Override
    public Reproduccion agregar(Reproduccion view) {
        reproduccionRepository.agregar(view);
        return view;
    }

}
