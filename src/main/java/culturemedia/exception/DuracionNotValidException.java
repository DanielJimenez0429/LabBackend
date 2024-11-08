package culturemedia.exception;

import java.text.MessageFormat;

public class DuracionNotValidException extends CulturotecaException {
    public DuracionNotValidException(String titulo, Double duracion) {
        super(MessageFormat.format("Duracion no valida para el video: {}.Duracion:{}" ,titulo ,duracion));
    }
}
