package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.impl.CulturotecaServiceImpl;

public class CultureMediaController {

	private final CulturotecaServiceImpl culturotecaService;


	public CultureMediaController(CulturotecaServiceImpl cultureMediaService) {
		this.culturotecaService = cultureMediaService;
	}


	public List<Video> listarTodos() throws VideoNotFoundException {
		List<Video> videos = culturotecaService.listarTodos();
		return videos;
	}


}
