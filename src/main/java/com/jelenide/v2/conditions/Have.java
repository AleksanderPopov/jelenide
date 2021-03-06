package com.jelenide.v2.conditions;

import com.jelenide.v2.jelements.Jelement;
import com.jelenide.v2.jelements.Jelements;
import org.openqa.selenium.WebDriverException;

/**
 * Created by Alex on 7/17/2017.
 */
public class Have {

  public static <T extends Jelement> JelementsCondition<T> size(int size) {
    return new JelementsCondition<T>() {
      @Override
      public String errorMessage() {
        return "custom error message";
      }

      @Override
      public Jelements<T> apply(Jelements<T> jelements) {
        return jelements.toWebElements().size() == size ? jelements : null;
      }
    };
  }

  public static <T extends Jelement> JelementsCondition<T> sizeGreaterThanOrEqual(int size) {
    return new JelementsCondition<T>() {
      @Override
      public String errorMessage() {
        return "custom error message";
      }

      @Override
      public Jelements<T> apply(Jelements<T> jelements) {
        return jelements.toWebElements().size() >= size ? jelements : null;
      }
    };
  }

  public static JelementCondition text(String text) {
    return new JelementCondition() {
      @Override
      public String errorMessage() {
        return "custom error message";
      }

      @Override
      public Jelement apply(Jelement jelement) {
        try {
          return jelement.toWebElement().getText().contains(text) ? jelement : null;
        } catch (WebDriverException e) {
          return null;
        }
      }
    };
  }

}
