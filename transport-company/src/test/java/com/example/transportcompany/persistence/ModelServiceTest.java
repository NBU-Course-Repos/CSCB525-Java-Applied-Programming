package com.example.transportcompany.persistence;

/**
 * Test interface that defines the base CRUD tests that need to be
 * implemented by the persistence model service tests
 */
interface ModelServiceTest {

    void create();

    void read();

    void update();

    void delete();
}
