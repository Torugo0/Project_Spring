package br.com.fiap.mp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.mp.model.entity.Pedido;
import br.com.fiap.mp.model.entity.StatusPedido;
import br.com.fiap.mp.model.repository.PedidoRepository;

@RestController
@RequestMapping("/home")
public class HomeController {
    /*
     * @GetMapping no método hello(), indicado ao Spring MVC que este método que deve
     * ser executado ao receber uma requisição do tipo GET. Observe que este método
     * retorna apenas uma String (que neste nosso exemplo é o nome da hello que deve
     * ser chamada).
     */

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ModelAndView hello() {

        List<Pedido> pedidos = pedidoRepository.findAll();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidos);
        return mv; // Aqui retorna o nome da pasta, ele vai buscar isso em templates
    }

    @GetMapping("/{status}")
    public ModelAndView porStatus(@PathVariable("status") String status) {
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));

        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidos);
        mv.addObject("status", status);
        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView onError() {
        ModelAndView mv = new ModelAndView("redirect:/home");
        return mv;
    }

}
