package fr.uge.rest.server;

import java.rmi.RemoteException;

import fr.uge.rest.user.IUser;
import fr.uge.rest.user.IUserService;

public class AddBikeToUserObserver implements WaitingFileObserver {

	@Override
	public void onNotAvailableBike(IUserService userService, long id, IUser user) {
		try {
			if (!userService.isUserWaiting(id, user)) {
				userService.putInWaitingLine(id, user);
			}
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onBikeRecovery(IUserService userService, long id) {
		try {
			userService.takeFirstUserFromWaitingLine(id);
			//TODO say to user he can but the bike.
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

}
