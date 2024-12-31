package com.example.malkijenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcSom {
    // Méthode pour calculer la somme de deux entiers
    @GetMapping("/calculate-sum")
    public int calculSomme(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}
