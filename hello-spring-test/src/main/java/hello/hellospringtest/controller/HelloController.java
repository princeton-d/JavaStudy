package hello.hellospringtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("names") String name) {
    return "hello " + name;
  }

  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("names") String name, @RequestParam("age") int age,@RequestParam("gender") String gender) {
    Hello hello = new Hello();
    hello.setName(name);
    hello.setAge(age);
    hello.setGender(gender);
    return hello;
  }

  static class Hello {
    private String name;
    private int age;
    private String gender;

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getGender() {
      return gender;
    }

    public void setGender(String gender) {
      this.gender = gender;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
