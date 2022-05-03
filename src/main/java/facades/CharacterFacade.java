package facades;

import entities.Character;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CharacterFacade {
    private static EntityManagerFactory emf;
    private static CharacterFacade instance;

    private CharacterFacade() {
    }

    public static CharacterFacade getCharacterFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CharacterFacade();
        }
        return instance;
    }

    public Character getCharacterById(long id) {
        EntityManager em = emf.createEntityManager();
        Character character = em.find(Character.class, id);
        return character;
    }

    public List<Character> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Character> query = em.createQuery("SELECT c FROM Character c", Character.class);
        List<Character> characters = query.getResultList();
        return characters;
    }

}
