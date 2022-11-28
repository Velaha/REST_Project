package fr.uge.rest.main;

import fr.uge.rest.bike.IBikeService;
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
	
	public MainController() throws MalformedURLException, RemoteException, NotBoundException {
		this.bikeService = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
		this.userService = (IUserService) Naming.lookup("rmi://localhost:1098/UserService");
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


	// ADMIN
	@GetMapping("/admin/addBike")
	public String getAddBikeForm(Model model) {
		model.addAttribute("state", "");
		return "addBikeForm";
	}

	@PostMapping(value = "/admin/addBike", params = "add")
	public String postAddBikeFormAdd(@ModelAttribute("state") String state,
								  BindingResult bindingResult,
								  Model model) throws RemoteException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("result", "Bike didn't added");
			System.out.println("not added");
			return "addBikeForm";
		}
		model.addAttribute("result", "Bike added");
		var lastId = bikeService.getLastId();
		bikeService.addBike(lastId, state);
		return "addBikeForm";
	}

	@PostMapping(value = "/admin/addBike", params = "return")
	public String postAddBikeReturn() {
		return "redirect:/entry";
	}
}
