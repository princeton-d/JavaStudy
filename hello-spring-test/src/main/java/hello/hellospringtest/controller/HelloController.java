package hello.hellospringtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("testData", "hello!!");
    return "hello";
  }

  @GetMapping("spring")
  public String spring(Model model) {
    model.addAttribute("testData", "spring!!");
    return "spring";
  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("names") String name, Model model) {
    model.addAttribute("names", name + " webSteak");
    return "hello-template";
  }
}
