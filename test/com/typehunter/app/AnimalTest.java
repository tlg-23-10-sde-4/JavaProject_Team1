package com.typehunter.app;

import com.typehunter.Animal;
import org.junit.Test;
import static org.junit.Assert.*;

class AnimalTest {

    @Test
    public void hit_shouldIncrementNumberOfHits_shouldDieAfterHitsRequiredEqualsHitsTaken() {
        Animal deer = new Animal("Deer", 3);
        assertFalse(deer.isDead());
        deer.hit();
        deer.hit();
        assertFalse(deer.isDead());
        deer.hit();
        assertTrue(deer.isDead());
    }
}