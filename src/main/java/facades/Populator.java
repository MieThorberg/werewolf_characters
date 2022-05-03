/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CharacterDTO;
import dtos.RenameMeDTO;
import entities.Character;
import entities.RenameMe;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        CharacterFacade characterFacade = CharacterFacade.getCharacterFacade(emf);
        Character character = new Character("werewolf", "whrrrr", "?");
        Character character1 = new Character("villager", "arrhh", "?");
        characterFacade.create(new CharacterDTO(character));
        characterFacade.create(new CharacterDTO(character1));



//        FacadeExample fe = FacadeExample.getFacadeExample(emf);
//        fe.create(new RenameMeDTO(new RenameMe("First 1", "Last 1")));
//        fe.create(new RenameMeDTO(new RenameMe("First 2", "Last 2")));
//        fe.create(new RenameMeDTO(new RenameMe("First 3", "Last 3")));
    }
    
    public static void main(String[] args) {
        populate();
    }
}
