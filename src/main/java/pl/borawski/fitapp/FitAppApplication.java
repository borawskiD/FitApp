package pl.borawski.fitapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class FitAppApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(FitAppApplication.class, args);
    }

}
