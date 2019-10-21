package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    private static final List<String> OBRAZKY = Arrays.asList(
            "images/pexeso/0.jpg",
            "images/pexeso/1.jpg",
            "images/pexeso/2.jpg",
            "images/pexeso/3.jpg",
            "images/pexeso/4.jpg",
            "images/pexeso/5.jpg",
            "images/pexeso/6.jpg",
            "images/pexeso/7.jpg");

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView drzakNaDataAJmenoStranky = new ModelAndView("index");
        return drzakNaDataAJmenoStranky;
    }

    @RequestMapping("/karticky.html")
    public ModelAndView zobrazKarticky() {
        ModelAndView drzakNaDataAJmenoStranky = new ModelAndView("karticky");

        Random nahodneCislo = new Random();

        List<String> obrazkyDvojice = new ArrayList<>();
        obrazkyDvojice.addAll(OBRAZKY);
        obrazkyDvojice.addAll(OBRAZKY);

        int pocetObrazku = obrazkyDvojice.size();

        List<String> karticky = new ArrayList<>();
        for (int i = 0; i < pocetObrazku; i++) {
            int cislo = nahodneCislo.nextInt(obrazkyDvojice.size());
            karticky.add(obrazkyDvojice.get(cislo));
            obrazkyDvojice.remove(cislo);
        }

        drzakNaDataAJmenoStranky.addObject("karticky", karticky);

        return drzakNaDataAJmenoStranky;
    }

    @RequestMapping("/hraci.html")
    public ModelAndView zobrazHraci() {
        ModelAndView drzakNaDataAJmenoStranky = new ModelAndView("hraci");

        List<Hrac> seznamHracu = new ArrayList<>();
        seznamHracu.add(new Hrac("Pinkie", "Pie", "pinki@gmail.com", 20, 100));
        seznamHracu.add(new Hrac("Rainbow", "Dash", "dash@gmail.com", 80, 100));
        seznamHracu.add(new Hrac("Sunset", "Shimmer", "sunset@gmail.com", 950, 1000));
        seznamHracu.add(new Hrac("Sweetie", "Drops", "sweetie@gmail.com", 50, 500));
        seznamHracu.add(new Hrac("Twilight", "Sparkle", "twilight@gmail.com", 75, 400));

        drzakNaDataAJmenoStranky.addObject("seznamHracu", seznamHracu);

        return drzakNaDataAJmenoStranky;
    }

}
