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
        videoRepository.agregar(video);
        return video;
    }


    @Override
    public Reproduccion agregar(Reproduccion reproduccion) {
        reproduccionRepository.agregar(reproduccion);
        return reproduccion;
    }
    @Override
    public List<Video> encontrarPorTitulo(String titulo) throws VideoNotFoundException {
        List<Video> videos = videoRepository.listarTodos();
        List<Video> videosEncontrados = new ArrayList<>();
        for (Video video : videos) {
            if (video.titulo().toLowerCase().contains(titulo.toLowerCase())) {
                videosEncontrados.add(video);
            }
        }
        if (videosEncontrados.isEmpty()) {
            throw new VideoNotFoundException(titulo);
        }
        return videosEncontrados;
    }
    @Override
    public List<Video> encontrarPorDuracion(Double duracion) throws VideoNotFoundException {
        List<Video> videos = videoRepository.listarTodos();
        List<Video> videosGuardados = new ArrayList<>();
        for (Video video : videos) {
            if (Math.abs(video.duracion() - duracion) < 0.001) { // Comparación con tolerancia
                videosGuardados.add(video);
            }
        }
        if (videosGuardados.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videosGuardados;
    }


}
