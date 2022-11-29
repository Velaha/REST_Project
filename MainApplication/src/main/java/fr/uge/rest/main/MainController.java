package fr.uge.rest.main;

import fr.uge.rest.bike.IBikeService;
import fr.uge.rest.user.IUser;
import fr.uge.rest.user.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Controller
public class MainController {

	private IBikeService bikeService;
	private IUserService userService;
	private IUser currentUser;
	
	public MainController() throws MalformedURLException, RemoteException, NotBoundException {
		this.bikeService = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
		this.userService = (IUserService) Naming.lookup("rmi://localhost:1098/UserService");
		this.currentUser = null;
	}

	// ENTRY
	@GetMapping("/entry")
	public String getEntry() {
		return "entry";
	}

	@PostMapping(value = "/entry", params = "admin")
	public String postEntryAdmin() {
		return "redirect:/admin/addBike";
	}

	@PostMapping(value = "/entry", params = "user")
	public String postEntryUser() {
		return "redirect:/userForm";
	}



	// ADMIN - OFFER BIKE
	@GetMapping("/admin/addBike")
	public String getAdminAddBikeForm(Model model) {
		model.addAttribute("state", "");
		return "addBikeForm";
	}

	@PostMapping(value = "/admin/addBike", params = "add")
	public String postAdminAddBikeFormAdd(@ModelAttribute("state") String state,
								  BindingResult bindingResult,
								  Model model) throws RemoteException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("result", "Bike didn't added");
			return "addBikeForm";
		}
		model.addAttribute("result", "Bike added");
		var lastId = bikeService.getLastId();
		bikeService.addBike(lastId, state);
		return "addBikeForm";
	}

	@PostMapping(value = "/admin/addBike", params = "return")
	public String postAdminAddBikeReturn() {
		return "redirect:/entry";
	}



	// USER - LOGIN
	@GetMapping("/userForm")
	public String getUserForm(Model model) {
		model.addAttribute("name", "");
		return "userForm";
	}

	@PostMapping(value = "/userForm", params = "connect")
	public String postUserFormConnect(@ModelAttribute("name") String name,
							   BindingResult bindingResult,
							   Model model) throws RemoteException {
		if (bindingResult.hasErrors() || name.isBlank()) {
			model.addAttribute("result", "Unable to login");
			return "userForm";
		}
		model.addAttribute("result", "User logged");
		var lastId = userService.getLastId();
		userService.addUser(lastId, name);
		this.currentUser = userService.getUser(lastId);
		return "redirect:/userMainMenu";
	}

	@PostMapping(value = "/userForm", params = "return")
	public String postUserFormReturn() {
		return "redirect:/entry";
	}



	// USER - MAIN MENU
	@GetMapping("/userMainMenu")
	public String getUserMainMenu(Model model) throws RemoteException {
		if (this.currentUser == null) {
			return "redirect:/entry";
		}
		model.addAttribute("name", this.currentUser.getName());
		model.addAttribute("bike", this.currentUser.getBike());
		return "userMainMenu";
	}

	@PostMapping(value = "/userMainMenu", params = "rentBike")
	public String postUserMainMenuRent() {
		return "soon";
	}

	@PostMapping(value = "/userMainMenu", params = "returnBike")
	public String postUserMainMenuReturn() {
		return "soon";
	}

	@PostMapping(value = "/userMainMenu", params = "offerBike")
	public String postUserMainMenuOffer() {
		return "redirect:/user/addBike";
	}

	@PostMapping(value = "/userMainMenu", params = "disconnect")
	public String postUserMainMenuDisconnect() throws RemoteException {
		userService.removeUser(this.currentUser.getId());
		this.currentUser = null;
		return "redirect:/userForm";
	}



	// USER - OFFER BIKE
	@GetMapping("/user/addBike")
	public String getUserAddBikeForm(Model model) {
		model.addAttribute("state", "");
		return "addBikeForm";
	}

	@PostMapping(value = "/user/addBike", params = "add")
	public String postUserAddBikeFormAdd(@ModelAttribute("state") String state,
										  BindingResult bindingResult,
										  Model model) throws RemoteException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("result", "Bike didn't added");
			return "addBikeForm";
		}
		model.addAttribute("result", "Bike added");
		var lastId = bikeService.getLastId();
		bikeService.addBike(lastId, state);
		return "addBikeForm";
	}

	@PostMapping(value = "/user/addBike", params = "return")
	public String postUserAddBikeReturn() {
		return "redirect:/userMainMenu";
	}



	// USER - RENT BIKE

	// USER - RETURN BIKE
}
