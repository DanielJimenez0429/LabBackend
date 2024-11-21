package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturotecaService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class CultureMediaController {

	private final CulturotecaService culturotecaService;


	public CultureMediaController(CulturotecaService culturotecaService) {
		this.culturotecaService = culturotecaService;
	}


	@GetMapping("/videos")
	public List<Video> listarTodos() throws VideoNotFoundException {
		return culturotecaService.listarTodos();
	}

	@PostMapping("/videos")
	public Video agregar(@RequestBody Video video) throws VideoNotFoundException {
		return this.culturotecaService.agregar(video);
	}


}
