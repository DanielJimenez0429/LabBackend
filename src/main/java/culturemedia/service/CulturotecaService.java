package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Reproduccion;
import culturemedia.model.Video;
import java.util.List;


public interface CulturotecaService {
    List<Video> listarTodos()throws VideoNotFoundException;

    Video agregar(Video video);
    Reproduccion agregar (Reproduccion reproduccion);

    List<Video> encontrarPorTitulo(String titulo) throws VideoNotFoundException;
    List<Video> encontrarPorDuracion(Double duracion) throws VideoNotFoundException;
}
