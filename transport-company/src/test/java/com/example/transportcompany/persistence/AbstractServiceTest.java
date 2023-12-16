package com.example.transportcompany.persistence;

import com.example.transportcompany.AbstractTest;

public abstract class AbstractServiceTest extends AbstractTest {

    abstract void create();

    abstract void read();

    abstract void update();

    abstract void delete();
}
