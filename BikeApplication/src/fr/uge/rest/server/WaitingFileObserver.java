package fr.uge.rest.server;

import fr.uge.rest.bike.IBike;

public interface WaitingFileObserver {
	void onBikeReturn(BikeService bikeService, IBike bike);
}
