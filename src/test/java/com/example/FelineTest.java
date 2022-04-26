package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline spyFeline;


    @Test
    public void eatMeatTest() throws Exception {
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void getFamilyTest(){
        Feline feline = new Feline();
        String family = feline.getFamily();
        String expected = "Кошачьи";
        Assert.assertEquals(expected, family);
    }

    @Test
    public void getKittensDefaultTest(){
        spyFeline.getKittens();
        Mockito.verify(spyFeline).getKittens(1);
    }

    @Test
    public void getKittensOptionalTest(){
        Feline feline = new Feline();
        int expectedKittens = 5;
        int kittens = feline.getKittens(expectedKittens);
        Assert.assertEquals(expectedKittens, kittens);
    }

}
