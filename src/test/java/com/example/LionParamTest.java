package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean expectedSex;

    public LionParamTest(String sex, boolean expectedSex){
        this.sex = sex;
        this.expectedSex = expectedSex;
    }

    @Parameterized.Parameters
    public static Object[][] getGenderData() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Feline feline;


    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(expectedSex, lion.doesHaveMane());
    }
}
