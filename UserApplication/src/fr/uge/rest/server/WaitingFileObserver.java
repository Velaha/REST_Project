package fr.uge.rest.server;

import fr.uge.rest.user.IUser;
import fr.uge.rest.user.IUserService;

public interface WaitingFileObserver {
	void onNotAvailableBike(IUserService userService, long id, IUser user);
	void onBikeRecovery(IUserService userService, long id);
}
