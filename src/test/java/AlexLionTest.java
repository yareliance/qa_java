package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AlexLionTest {
    private AlexLion alex;

    // Создаем объект перед каждым тестом
    @BeforeEach
    void setUp() throws Exception {
        alex = new AlexLion();
    }

    // Проверка конструктора: объект Алекс создан и у него есть грива
    @Test
    void testConstructor() {
        assertNotNull(alex);
        assertTrue(alex.doesHaveMane());
    }

    // Проверка списка друзей Алекса
    @Test
    void testGetFriends() {
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    // Проверка места проживания Алекса
    @Test
    void testGetPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    // Проверка, что у Алекса нет львят
    @Test
    void testGetKittens() {
        assertEquals(0, alex.getKittens());
    }

    // Проверка наследования: наличия гривы, семейства Кошачьи и рациона
    @Test
    void testInheritedMethods() throws Exception {
        assertTrue(alex.doesHaveMane());
        assertEquals("Кошачьи", alex.getFamily());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), alex.getFood());
    }
}
