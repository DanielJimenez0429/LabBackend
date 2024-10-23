package culturemedia.service.impl;

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
    public List<Video> listarTodos() {
        return List.of();
    }

    @Override
    public Video agregar(Video video) {
        return null;
    }

    @Override
    public Video agregar(Reproduccion reproduccion){
        return null;
    }
}
