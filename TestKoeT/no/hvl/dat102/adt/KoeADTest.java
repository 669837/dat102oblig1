package no.hvl.dat102.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class KoeADTest {

    private KoeADT<Integer> koe;
    
    protected abstract KoeADT<Integer> reset();
    
    @BeforeEach
    void setup() {
        koe = reset();
    }
    
    @Test
    void innKoeTest() {
        koe.innKoe(1);
        koe.innKoe(2);
        koe.innKoe(3);
        
        assertEquals(3, koe.utKoe());
        assertEquals(2, koe.utKoe());
        assertEquals(1, koe.utKoe());
        
    }
        
    @Test
    void foersteTest() {
        koe.innKoe(1);
        koe.innKoe(2);
        
        assertEquals(1, koe.foerste());
        assertEquals(1, koe.foerste());
        assertEquals(1, koe.utKoe());
    }
    
    @Test
    void erTomTest() {
        assertTrue(koe.erTom());
        
        koe.innKoe(1);
        
        assertFalse(koe.erTom());
    }
    
    @Test
    void utKoeTest() {
        koe.innKoe(1);
        koe.innKoe(2);
        koe.innKoe(3);
        
        assertEquals(1, koe.utKoe());
        assertEquals(2, koe.utKoe());
        assertEquals(3, koe.utKoe());
    }
    
    @Test
    void EmptyCollectionExceptionTest() {
        assertThrows(EmptyCollectionException.class, () -> koe.foerste());
        assertThrows(EmptyCollectionException.class, () -> koe.utKoe());
    }
}