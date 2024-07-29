package web.controller;

import web.model.User;
import web.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceInt userService;

	@GetMapping
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "user-list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("user", new User());
		return "user-form";
	}

	@PostMapping("/add")
	public String addUser(@ModelAttribute User user) {
		userService.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("/edit")
	public String showEditForm(@RequestParam("id") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user-form";
	}

	@PostMapping("/edit")
	public String updateUser(@ModelAttribute User user) {
		userService.updateUser(user);
		return "redirect:/users";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}
