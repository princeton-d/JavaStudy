package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!!");
    return "hello"; // 데이터를 resources.templates 폴더 안에 있는 hello 라는 이름의 html 로 넘겨줌
  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
  }

  @GetMapping("hello-string")
  @ResponseBody // http 에 body 부분에 이 데이터를 직접 넣어주겠다는 뜻
  public String helloString(@RequestParam("name") String name) {
    return name;
  }

  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("name") String name, @RequestParam("age") int age) {
    Hello hello = new Hello();
    hello.setName(name);
    hello.setAge(age);
    return hello;
  }

  static class Hello {
    private String name;
    private int age;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }
}
