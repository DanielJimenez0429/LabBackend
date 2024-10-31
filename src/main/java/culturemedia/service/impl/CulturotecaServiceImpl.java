package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Reproduccion;
import culturemedia.model.Video;
import culturemedia.service.CulturotecaService;
import culturemedia.repository.ReproduccionRepository;
import culturemedia.repository.VideoRepository;

import java.util.ArrayList;
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
        this.videoRepository.agregar(video);
        return video;
    }

    @Override
    public Reproduccion agregar(Reproduccion reproduccion) {
        this.reproduccionRepository.agregar(reproduccion);
        return reproduccion;
    }


    @Override
    public List<Video> encontrarPorTitulo(String titulo) throws VideoNotFoundException {
        List<Video> videosEncontrados = this.videoRepository.buscar(titulo);
        if (videosEncontrados.isEmpty()) {
            throw new VideoNotFoundException(titulo);
        }
        return videosEncontrados;
    }
    @Override
    public List<Video> encontrarPorDuracion(Double duracionDesde, Double duracionHasta) throws VideoNotFoundException {
        List<Video> videosGuardados = this.videoRepository.buscar(duracionDesde, duracionHasta);

        if (videosGuardados.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videosGuardados;

    }

}
