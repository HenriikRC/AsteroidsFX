package dk.sdu.mmmi.cbse.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/points")
@CrossOrigin
public class PointSystem {

    private int score = 0;

    @GetMapping()
    public int getScore() {
        return score;
    }

    @PutMapping("/{points}")
    public int addPoints(@PathVariable int points) {
        score += points;
        return score;
    }

    public static void main(String[] args) {
        SpringApplication.run(PointSystem.class, args);
    }
}
