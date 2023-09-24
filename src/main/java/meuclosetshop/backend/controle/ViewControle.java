package meuclosetshop.backend.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewControle {

    @GetMapping("/principal")
    public String abrirTelaPrincipal() {
        return "Frontend/html/index.html";
    }
}
