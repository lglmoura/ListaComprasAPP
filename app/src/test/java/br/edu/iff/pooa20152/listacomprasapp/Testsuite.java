package br.edu.iff.pooa20152.listacomprasapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.edu.iff.pooa20152.listacomprasapp.domain.FabricanteDomainTest;
import br.edu.iff.pooa20152.listacomprasapp.domain.FabricanteServiceTest;

/**
 * Created by lglmoura on 03/05/16.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        RestFullUnitTest.class,
        FabricanteDomainTest.class,
        FabricanteServiceTest.class
})
public class Testsuite {
}
