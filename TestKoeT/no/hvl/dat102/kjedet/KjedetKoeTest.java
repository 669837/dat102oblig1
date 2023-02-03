package no.hvl.dat102.kjedet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTest;

public class KjedetKoeTest extends KoeADTest {
       @Override
        protected KoeADT<Integer> reset() {
            return new KjedetKoe<Integer>();
        }
       
       @Test
        public void innKoeTest() {
            KoeADT<Integer> koe = reset();
            koe.innKoe(3);
            assertEquals(3, (int) koe.foerste());
        }
} 