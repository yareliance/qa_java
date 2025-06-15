package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    // Проверка, что метод возвращает семейство Кошачьи
    @Test
    void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Проверка работы метода с разным количеством котят
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5})
    void testGetKittens(int count) {
        Feline feline = new Feline();
        assertEquals(count, feline.getKittens(count));
        assertEquals(1, feline.getKittens()); // проверка дефолтного значения
    }

    // Проверка списка еды для хищника
    @Test
    void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertIterableEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
