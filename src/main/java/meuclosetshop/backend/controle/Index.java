package meuclosetshop.backend.controle;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meuclosetshop")

// URL: http://localhost:8080/

public class Index{

    @GetMapping("/")
    public String hello(){
        return "Ola mundo!" + new Date();
    }
}