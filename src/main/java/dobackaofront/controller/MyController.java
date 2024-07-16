package dobackaofront.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    private final ServletContext servletContext;

    public MyController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response, Model model) {
        // Obter um parâmetro de requisição
        String name = request.getParameter("name");
        if (name == null) {
            name = "World";
        }

        // Adicionar atributo ao modelo
        model.addAttribute("name", name);

        // Definir cabeçalho de resposta
        response.setHeader("Custom-Header", "Example");

        // Acessar um atributo do contexto
        String contextPath = servletContext.getContextPath();
        model.addAttribute("contextPath", contextPath);

        // Renderizar o template Thymeleaf
        return "hello";
    }
}
