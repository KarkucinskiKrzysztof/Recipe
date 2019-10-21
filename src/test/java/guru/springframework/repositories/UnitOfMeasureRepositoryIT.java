package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
// dostarcza wbudowaną DB orazkonfiguruje SpringDataJPA
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    @DirtiesContext
    // odpala dwa razy kontekst ta adnotacje stosuje sie jeśli możliwe jest że dany test coś pozmienia w kontekscie.
    public void findByDescription() {
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("############################################");
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }
    @Test
    public void findByDescriptionCup() {
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("############################################");
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", uomOptional.get().getDescription());
    }
}