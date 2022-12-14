package fr.uge.rest.main;

import fr.uge.rest.bike.IBikeService;
import fr.uge.rest.serviceweb.banque.Banque;
import fr.uge.rest.serviceweb.shop.Shop;
import fr.uge.rest.serviceweb.shop.ShopServiceLocator;
import fr.uge.rest.user.IUser;
import fr.uge.rest.user.IUserService;
import fr.uge.rest.webservice.shop.ShopClient;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



@Controller
public class MainController {
	private IBikeService bikeService;
	private IUserService userService;
	private Shop shop;
	private Banque banque;
	private IUser currentUser;

	public MainController() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		this.bikeService = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
		this.userService = (IUserService) Naming.lookup("rmi://localhost:1098/UserService");
		this.shop = new ShopClient().getShop();
		this.banque = new ShopClient().getBanque();
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
		model.addAttribute("etat", "");
		model.addAttribute("price", "");
		return "addBikeForm";
	}

	@PostMapping(value = "/admin/addBike", params = "add")
	public String postAdminAddBikeFormAdd(@ModelAttribute("etat") String etat,
										  @ModelAttribute("price") String price,
										  Model model) throws RemoteException {
		if (etat.isBlank()) {
			model.addAttribute("result", "Bike didn't added");
			return "addBikeForm";
		}
		model.addAttribute("result", "Bike added");
		var lastId = bikeService.getLastId();
		bikeService.addBike(lastId, etat);
		bikeService.getBike(lastId).setPrice(Double.parseDouble(price));
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
		model.addAttribute("funds", "");
		return "userForm";
	}

	@PostMapping(value = "/userForm", params = "connect")
	public String postUserFormConnect(@ModelAttribute("name") String name,
									  @ModelAttribute("funds") String funds,
									  BindingResult bindingResult,
									  Model model) throws RemoteException {
		if (bindingResult.hasErrors() || name.isBlank() || funds.isBlank()) {
			model.addAttribute("result", "Unable to login");
			return "userForm";
		}
		model.addAttribute("result", "User logged");
		var lastId = userService.getLastId();
		userService.addUser(lastId, name);
		this.currentUser = userService.getUser(lastId);
		this.shop.addAccount(this.currentUser.getId(), Double.parseDouble(funds));

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
		model.addAttribute("money", banque.checkFundsInAnotherIso( this.currentUser.getId(), "EUR"));
		return "userMainMenu";
	}

	@PostMapping(value = "/userMainMenu", params = "rentBike")
	public String postUserMainMenuRent() {
		return "redirect:/userRentBike";
	}

	@PostMapping(value = "/userMainMenu", params = "returnBike")
	public String postUserMainMenuReturn() {
		return "redirect:/userReturnBike";
	}

	@PostMapping(value = "/userMainMenu", params = "offerBike")
	public String postUserMainMenuOffer() {
		return "redirect:/user/addBike";
	}

	@PostMapping(value = "/userMainMenu", params = "buyBike")
	public String postUserMainMenuBuy() {
		return "redirect:/userBuyBike";
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
		if (this.currentUser == null) {
			return "redirect:/entry";
		}
		model.addAttribute("etat", "");
		model.addAttribute("price", "");
		return "addBikeForm";
	}

	@PostMapping(value = "/user/addBike", params = "add")
	public String postUserAddBikeFormAdd(@ModelAttribute("etat") String etat,
										 @ModelAttribute("price") String price,
										 Model model) throws RemoteException {
		if (etat.isBlank()) {
			model.addAttribute("result", "Bike didn't added");
			return "addBikeForm";
		}
		model.addAttribute("result", "Bike added");
		var lastId = bikeService.getLastId();
		bikeService.addBike(lastId, etat);
		bikeService.getBike(lastId).setPrice(Double.parseDouble(price));
		return "addBikeForm";
	}

	@PostMapping(value = "/user/addBike", params = "return")
	public String postUserAddBikeReturn() {
		return "redirect:/userMainMenu";
	}



	// USER - RENT BIKE
	@GetMapping("/userRentBike")
	public String getUserRentBike(Model model) throws RemoteException {
		if (this.currentUser == null) {
			return "redirect:/entry";
		}
		if (this.bikeService.getAllBikes().isEmpty()) {
			model.addAttribute("bikes", null);
		} else {
			model.addAttribute("bikes", bikeService.getAllBikes());
		}
		return "userRentBike";
	}

	@PostMapping(value = "/userRentBike")
	public String postUserRentBikeChoose(@RequestParam(value = "choose") int id, Model model) throws RemoteException {
		var bike = bikeService.getBike(id);

		if (!bike.getAvailable()) {
			/*
			bike.addToQueue(this.currentUser.getId());
			 */
			return "redirect:/userMainMenu";
		} else if (this.currentUser.getBike() != null) {
			return "redirect:/userMainMenu";
		} else {
			this.currentUser.setBike(bike);
			bike.setAvailable(false);
			model.addAttribute("result", "Bike rented");
		}
		return "redirect:/userRentBike";
	}

	@PostMapping(value = "/userRentBike", params = "return")
	public String postUserRentBikeReturn() {
		return "redirect:/userMainMenu";
	}



	// USER - RETURN BIKE
	@GetMapping("/userReturnBike")
	public String getUserReturnBike(Model model) throws RemoteException {
		if (this.currentUser == null) {
			return "redirect:/entry";
		}
		model.addAttribute("bike", this.currentUser.getBike());
		model.addAttribute("etat", "");
		model.addAttribute("comment", "");
		model.addAttribute("note", "");
		return "userReturnBike";
	}

	@PostMapping(value = "/userReturnBike", params = "valid")
	public String postUserReturnBikeValidate(@ModelAttribute("etat") String etat,
											 @ModelAttribute("price") String price,
											 @ModelAttribute("comment") String comment,
											 @ModelAttribute("note") String note) throws RemoteException {
		var bike = this.currentUser.getBike();
		if (!etat.isBlank()) {
			bike.setEtat(etat);
		} if (!comment.isBlank()) {
			bike.addComment(comment);
		} if (!note.isBlank()) {
			int newNote = Integer.parseInt(note);
			bike.addNote(newNote);
		}

		bike.setAvailable(true);
		bike.addTimesRented();
		/*
		var queue = bike.popQueue();
		if (queue.isPresent()) {
			userService.getUser(queue.get()).setBike(bike);
			bike.setAvailable(false);
		}
		 */
		this.currentUser.setBike(null);
		return "redirect:/userReturnBike";
	}

	@PostMapping(value = "/userReturnBike", params = "return")
	public String postUserReturnBikeReturn() {
		return "redirect:/userMainMenu";
	}



	// USER - BUY BIKE
	@GetMapping("/userBuyBike")
	public String getUserBuyBike(Model model) throws RemoteException {
		if (this.currentUser == null) {
			return "redirect:/entry";
		}
		model.addAttribute("bikes", bikeService.getSaleableBike());
		model.addAttribute("money", banque.checkFundsInAnotherIso( this.currentUser.getId(), "EUR"));
		return "userBuyBike";
	}


	@PostMapping("/userBuyBike")
	public String postUserBuyBikeChoose(@RequestParam(value = "choose") int id, Model model) throws RemoteException {
		if (!this.shop.canSell(id, this.currentUser.getId(), "EUR")) {
			return "redirect:/userMainMenu";
		} else {
			this.shop.sellBike(id, this.currentUser.getId(), "EUR");
			model.addAttribute("result", "Bike bought");
		}
		return "redirect:/userBuyBike";
	}

	@PostMapping(value = "/userBuyBike", params = "return")
	public String postUserBuyBikeReturn() {
		return "userMainMenu";
	}
}


