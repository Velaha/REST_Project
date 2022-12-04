package fr.uge.rest.server;

import java.rmi.RemoteException;

import fr.uge.rest.bike.IBike;

public class AddBikeToUserObserver implements WaitingFileObserver {

	@Override
	public void onBikeReturn(BikeService bikeService, IBike bike) {
		try {
			var user = bikeService.takeFirstUserFromWaitingLine(bike.getId());
			user.setBike(bike);
			bike.setAvailable(false);
			// TODO Notify the user.
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

}
