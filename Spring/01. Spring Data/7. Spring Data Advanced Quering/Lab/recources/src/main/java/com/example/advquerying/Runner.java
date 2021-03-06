package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Runner(ShampooRepository shampooRepository, ShampooService shampooService, IngredientService ingredientService) {
        this.shampooRepository = shampooRepository;
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Transactional

    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select exercise number from 1 to 11: ");
        int exerciseNumber = Integer.parseInt(scanner.nextLine());

        if (exerciseNumber < 0 || exerciseNumber > 11) {
            System.out.println("Wrong exercise number!");
        }

        switch (exerciseNumber) {
            case 1 -> p01_SelectShampoosBySize();
            case 2 -> p02_SelectShampoosBySizeOrLabel();
            case 3 -> p03_SelectShampooByPrice();
            case 4 -> p04_SelectIngredientsByName();
            case 5 -> p05_SelectIngredientsByNames();
            case 6 -> p06_CountShampoosByPrice();
            case 7 -> p07_SelectShampoosByIngredients();
            case 8 -> p08_SelectShampoosByIngredientsCount();
            case 9 -> p09_DeleteIngredientsByName();
            case 10 -> p10_UpdateIngredientsByPrice();
            case 11 -> p11_UpdateIngredientsByNames();

        }



    }

    private void p11_UpdateIngredientsByNames () {

        List<String> names = new ArrayList<>();
        names.add("Apple");
        names.add("Cherry");

        int price = this.ingredientService.increasePriceByGivenIngredientsNames(new BigDecimal(12), names);
        System.out.println(price);

    }

    private void p10_UpdateIngredientsByPrice () {

        this.ingredientService.increasePriceBy(0.1);
    }


    private void p09_DeleteIngredientsByName () {

        this.ingredientService.deleteByName("Nettle");

    }


    private void p08_SelectShampoosByIngredientsCount () {

        this.shampooService.selectByIngredientsCount(2)
                .forEach(System.out::println);

    }

    private void p07_SelectShampoosByIngredients () {

        this.shampooRepository.findByIngredientsNames(Set.of("Berry", "Mineral-Collagen"))
                .forEach(System.out::println);

    }

    private void p06_CountShampoosByPrice () {

        int count = this.shampooService.countPriceLowerThan(BigDecimal.valueOf(8.5));

        System.out.println(count);

    }

    private void p05_SelectIngredientsByNames () {

        this.ingredientService.selectInNames(List.of("Lavender", "Herbs", "Apple"))
                .forEach(System.out::println);

    }

    private void p04_SelectIngredientsByName () {

        this.ingredientService.selectNameStartsWith("M")
                .forEach(System.out::println);

    }

    private void p03_SelectShampooByPrice(){

        this.shampooService.selectMoreExpensiveThan(BigDecimal.valueOf(5))
                .forEach(System.out::println);

    }

    private void p02_SelectShampoosBySizeOrLabel(){

        this.shampooService.selectBySizeOrLabelId(Size.MEDIUM, 10)
                .forEach(System.out::println);
    }

    private void p01_SelectShampoosBySize() {

        this.shampooRepository.findBySize(Size.MEDIUM)
                .forEach(System.out::println);
    }
}
