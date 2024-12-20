package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Reproduccion;
import culturemedia.model.Video;
import java.util.List;


public interface CulturotecaService {
    List<Video> listarTodos()throws VideoNotFoundException;

    Video agregar(Video video)throws VideoNotFoundException;
    Reproduccion agregar (Reproduccion reproduccion);

    List<Video> encontrarPorTitulo(String titulo) throws VideoNotFoundException;
    List<Video> encontrarPorDuracion(Double duracionDesde, Double duracionHasta) throws VideoNotFoundException;

;
}
