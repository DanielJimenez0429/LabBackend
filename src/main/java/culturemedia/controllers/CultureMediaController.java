package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturotecaService;

public class CultureMediaController {

	private final CulturotecaService culturotecaService;


	public CultureMediaController(CulturotecaService culturotecaService) {
		this.culturotecaService = culturotecaService;
	}


	public List<Video> listarTodos() throws VideoNotFoundException {
		List<Video> videos = culturotecaService.listarTodos();
		return videos;
	}


}
