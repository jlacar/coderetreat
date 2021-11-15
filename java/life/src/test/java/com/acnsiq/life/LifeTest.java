package com.acnsiq.life;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifeTest {
    {
        System.out.println("LifeTest instantiated");
    }

    Foo foo = new Foo();

//    @BeforeEach
//    public void setup() {
//        foo = new Foo();
//    }

    @Test
    public void foo1() throws Exception {
    }

    @Test
    public void foo2() throws Exception {
    }
}

class Foo {
    Foo() {
        System.out.println("Foo instantiated");
    }
}