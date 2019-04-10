package bg.nra.webServices.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("NRA REST WS", HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("Running OK", HttpStatus.OK);
    }
}
