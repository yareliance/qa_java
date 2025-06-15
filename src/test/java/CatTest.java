package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    // Создаем мок объекта Feline
    @Mock
    private Feline feline;
    private Cat cat;

    // Проверка, что Кошачьи говорят "Мяу"
    @Test
    void testGetSound() {
        cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    // Проверка, что Кошачьи едят мясо
    @Test
    void testGetFood() throws Exception {
        cat = new Cat(feline);
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        List<String> food = cat.getFood();
        assertIterableEquals(List.of("Мясо"), food);
    }
}
