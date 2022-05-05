package facades;

import dtos.CharacterDTO;
import entities.Character;
import entities.RenameMe;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFacadeTest {

    private static EntityManagerFactory emf;
    private static CharacterFacade facade;

    public CharacterFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = CharacterFacade.getCharacterFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Character.deleteAllRows").executeUpdate();
            em.persist(new Character("name1", "description1", "imagesource1", 0, 1, "none"));
            em.persist(new Character("name2", "description2", "imagesource2", 0, 1, "none"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    void getAllTest() {
        assertEquals(2, facade.getAll().size());
    }

    @Test
    void createTest() {
        CharacterDTO characterDTO = new CharacterDTO(new Character("name3", "description3", "imagesource3", 0, 1, "none"));
        facade.create(characterDTO);
        assertEquals(3, facade.getAll().size());
    }
}