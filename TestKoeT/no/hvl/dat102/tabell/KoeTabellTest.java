package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTest;

public class KoeTabellTest extends KoeADTest {
       @Override
        protected KoeADT<Integer> reset() {
            return new TabellSirkulaerKoe<Integer>();
        }        
} 