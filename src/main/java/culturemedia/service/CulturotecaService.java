package culturemedia.service;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.model.Reproduccion;
import culturemedia.model.Video;
import java.util.List;

public interface CulturotecaService {
    List<Video> listarTodos();
    Video agregar(Video video);
    Video agregar (Reproduccion reproduccion) throws DuracionNotValidException;
}
