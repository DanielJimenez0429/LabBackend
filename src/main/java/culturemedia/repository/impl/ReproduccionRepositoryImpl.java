package culturemedia.repository.impl;

import java.util.ArrayList;
import java.util.List;

import culturemedia.model.Reproduccion;
import culturemedia.repository.ReproduccionRepository;

public class ReproduccionRepositoryImpl implements ReproduccionRepository {

	private final List<Reproduccion> views;

	public ReproduccionRepositoryImpl() {
		this.views = new ArrayList<>();
	}

	@Override
	public Reproduccion agregar(Reproduccion reproduccion) {
		this.views.add( reproduccion );
		return reproduccion;
	}

}
