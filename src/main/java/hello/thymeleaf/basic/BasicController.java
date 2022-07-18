package hello.thymeleaf.basic;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Spring!!");
        return "basic/text-basic";
    }
    @GetMapping("text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello Spring!!");
        return "basic/text-unescaped";
    }

    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        ArrayList<User> users = new ArrayList<>();
        users.add(userA);
        users.add(userB);
        HashMap<String, User> userMap = new HashMap<String, User>();
        userMap.put("userA", userA);
        userMap.put("userB", userB);

        model.addAttribute("users", users);
        model.addAttribute("userMap", userMap);
        model.addAttribute("user", userA);

        return "basic/variable";
    }

    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

}
