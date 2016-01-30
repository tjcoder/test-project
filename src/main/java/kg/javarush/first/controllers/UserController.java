package kg.javarush.first.controllers;

import kg.javarush.first.model.User;
import kg.javarush.first.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String index(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "4") int size,
            @RequestParam(name = "query", defaultValue = "") String query,
            Model model)
    {
        Page<User> users = userService.listAllUsers(page, size, query);

        model.addAttribute("users", users);
        model.addAttribute("query", query);

        return "users";
    }


    @RequestMapping("user/new")
    public String create(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("buttonText", "Create a New User");
        return "form";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String store(@Valid User user, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "form";

        userService.saveUser(user);

        return "redirect:/user/" + user.getId();
    }

    @RequestMapping("user/{id}")
    public String show(@PathVariable Integer id, Model model)
    {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @RequestMapping("user/edit/{id}")
    public String update(@PathVariable Integer id, Model model)
    {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("buttonText", "Save Changes");
        return "form";
    }

    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Integer id)
    {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
