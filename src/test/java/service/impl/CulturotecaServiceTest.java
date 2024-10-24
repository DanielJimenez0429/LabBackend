package service.impl;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ReproduccionRepositoryImpl;
import culturemedia.service.CulturotecaService;
import culturemedia.service.impl.CulturotecaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import culturemedia.model.Video;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CulturotecaServiceTest {

    private CulturotecaService culturotecaService;

    @BeforeEach
    void init() {
        culturotecaService = new CulturotecaServiceImpl(new VideoRepositoryImpl(), new ReproduccionRepositoryImpl());
    }


    List<Video> listVideos() {
        List<Video> videos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));
        for (Video video : videos) {
            culturotecaService.agregar(video);
        }
        return videos;
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        listVideos();
        List<Video> videos = culturotecaService.listarTodos();
        assertEquals(6, videos.size());
        assertEquals("Título 1", videos.get(0).titulo());
        assertEquals("Título 2", videos.get(1).titulo());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        assertThrows(VideoNotFoundException.class, () -> {
            culturotecaService.listarTodos();
        });
    }
    @Test
    void when_FindByTitle_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        listVideos();
        List<Video> videos = culturotecaService.encontrarPorTitulo("Título");
        assertEquals(4, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        listVideos();
        assertThrows(VideoNotFoundException.class, () -> {
            culturotecaService.encontrarPorTitulo("Título Inexistente");
        });
    }

    @Test
    void when_FindByDuration_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        listVideos();
        List<Video> videos = culturotecaService.encontrarPorDuracion(5.5);
        assertEquals(1, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        listVideos();
        assertThrows(VideoNotFoundException.class, () -> {culturotecaService.encontrarPorDuracion(10.2);});
    }
}