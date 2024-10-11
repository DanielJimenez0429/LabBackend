package culturemedia.model;

import java.time.LocalDateTime;

public record Reproduccion(
        String usuario,
        LocalDateTime fechaHora,
        Integer edad
) {
}
