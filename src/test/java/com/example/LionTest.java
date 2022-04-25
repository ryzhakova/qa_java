package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest{

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        Assert.assertEquals(1, actual);
    }


    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы");
        Assert.assertEquals(expected, actual);
    }
}
