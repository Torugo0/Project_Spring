package br.com.fiap.mp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teste")
public class HelloController {
    /*
     @GetMapping no método hello(), indicado ao
    Spring MVC que este método que deve ser executado ao receber uma requisição
    do tipo GET. Observe que este método retorna apenas uma String (que neste nosso
    exemplo é o nome da view que deve ser chamada).
     */
    @GetMapping
    public String hello(Model model){
        model.addAttribute("nome", "VITOR HUGO");
        return "hello"; // Aqui retorna o nome da pasta, ele vai buscar isso em templates
    }
}
