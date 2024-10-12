package culturemedia.exception;

public class DuracionNotValidException extends CulturotecaException {
    public DuracionNotValidException(String titulo, Double duracion) {
        super("Duracion no valida" +titulo +duracion);
    }
}
