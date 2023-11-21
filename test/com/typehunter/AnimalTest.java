package com.typehunter;

import com.typehunter.Animal;
import com.typehunter.app.Location;
import org.junit.Test;

import java.nio.file.NoSuchFileException;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void animalCtor_shouldCreateNewInstanceOfAnimal_whenAnimalNameWordsAndArtAreCorrect() {
        Animal deer = new Animal("deer", 2, Location.FOREST);
        assertEquals(deer, deer);

        Animal wolf = new Animal("wolf", 4, Location.TUNDRA);
        assertEquals(wolf, wolf);

        Animal elephant = new Animal("elephant", 8, Location.SAVANNA);
        assertEquals(elephant, elephant);
    }
}