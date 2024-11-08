package service.impl;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.repository.ReproduccionRepository;
import culturemedia.repository.VideoRepository;
import culturemedia.service.CulturotecaService;
import culturemedia.service.impl.CulturotecaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import culturemedia.model.Video;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

public class CulturotecaServiceTest {

    private CulturotecaService culturotecaService;

    @Mock
    private VideoRepository videoRepository;

    @Mock
    private ReproduccionRepository reproduccionRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        culturotecaService = new CulturotecaServiceImpl(videoRepository,reproduccionRepository);
    }


    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        List<Video> videos = List.of(
                new Video("01", "Titulo 1", "----", 4.5),
                new Video("02", "Titulo 2", "----", 5.5),
                new Video("03", "Titulo 3", "----", 4.4),
                new Video("04", "Titulo 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));
        doReturn(videos).when(videoRepository).listarTodos();

        List<Video> actualVideos = culturotecaService.listarTodos();
        assertEquals(videos.size(), actualVideos.size());

    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(List.of()).when(videoRepository).listarTodos();

        assertThrows(VideoNotFoundException.class, () ->
                culturotecaService.listarTodos());
    }
    @Test
    void when_FindByTitle_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        doReturn(List.of(
                new Video("01", "Titulo 1", "----", 4.5),
                new Video("02", "Titulo 2", "----", 5.5),
                new Video("03", "Titulo 3", "----", 4.4),
                new Video("04", "Titulo 4", "----", 3.5)))
                .when(videoRepository).buscar("Titulo");

        List<Video> videos = culturotecaService.encontrarPorTitulo("Titulo");
        assertEquals(4, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(List.of()).when(videoRepository).buscar("Título Inexistente");

        assertThrows(VideoNotFoundException.class, () -> culturotecaService.encontrarPorTitulo("Titulo Inexistente"));
    }

    @Test
    void when_FindByDuration_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        doReturn(List.of(
                new Video("01", "Titulo 1", "----", 4.5),
                new Video("03", "Titulo 3", "----", 4.4),
                new Video("04", "Titulo 4", "----", 3.5)))
                .when(videoRepository).buscar(1.0,5.0);

        List<Video> videos = culturotecaService.encontrarPorDuracion(1.0,5.0);
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(List.of()).when(videoRepository).buscar(1.0,3.0);

        assertThrows(VideoNotFoundException.class, () ->
                culturotecaService.encontrarPorDuracion(1.0,3.0));
    }
}