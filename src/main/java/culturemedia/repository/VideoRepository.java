package culturemedia.repository;

import java.util.List;

import culturemedia.model.Video;

public interface VideoRepository {

    List<Video> listarTodos();
    Video agregar(Video video);
    List<Video> buscar(String titulo);
    List<Video> buscar(Double duracionDesde, Double duracionHasta);
}
