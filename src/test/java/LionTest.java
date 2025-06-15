package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    //Создание экземпляров разного пола
    private Lion lionMale;
    private Lion lionFemale;

    //Перед каждым тестом создаются экземпляры льва разного пола
    @BeforeEach
    void setUp() throws Exception {
        lionMale = new Lion(new Feline(), "Самец");
        lionFemale = new Lion(new Feline(), "Самка");
    }

    //Проверка, что количество котят одинаковое независимо от пола как указано в классе кошачьих
    @Test
    void testGetKittens() {
        assertEquals(1, lionMale.getKittens());
        assertEquals(1, lionFemale.getKittens());
    }

    // Проверка, что грива есть только у самца льва
    @Test
    void testDoesHaveMane() {
        assertTrue(lionMale.doesHaveMane());
        assertFalse(lionFemale.doesHaveMane());
    }

    // Проверка, что список еды как у всех хищных
    @Test
    void testGetFood() throws Exception {
        List<String> food = lionMale.getFood();
        assertIterableEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    // Проверка на допустимость значений пола
    @ParameterizedTest
    @ValueSource(strings = {"Мужской", "Женский", "male", "female"})
    void testInvalidSex(String sex) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(new Feline(), sex));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола"));
    }

    // Проверка недопустимое значение пола с нулем
    @Test
    void testInvalidSexWithNull() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(new Feline(), null));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола"));
    }
}