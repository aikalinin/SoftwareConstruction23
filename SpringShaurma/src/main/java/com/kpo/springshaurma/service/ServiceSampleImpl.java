package com.kpo.springshaurma.service;

import com.kpo.springshaurma.model.Ingredient;
import com.kpo.springshaurma.model.Ingredient.Type;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ServiceSampleImpl implements ServiceSample {

  public void modifyModel(Model model) {
    List<Ingredient> ingredients = Arrays.asList(
        new Ingredient("CHEESE", "Сырный", Type.SAUCE),
        new Ingredient("SRSW", "Кисло-сладкий", Type.SAUCE),
        new Ingredient("MAZIK", "Майонез", Type.SAUCE),
        new Ingredient("KTCHUNEZ", "100 Островов", Type.SAUCE),
        new Ingredient("WRAP_CHEESE", "Сырный", Type.WRAP),
        new Ingredient("WRAP_DEFAULT", "Обычный", Type.WRAP)
    );

    Ingredient.Type[] types = Ingredient.Type.values();
    for (Ingredient.Type type : types) {
      model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
    }
  }

  private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
    return ingredients
        .stream()
        .filter(x -> x.type().equals(type))
        .toList();
  }
}
