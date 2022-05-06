package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CharacterDTO;
import entities.Character;
import facades.CharacterFacade;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("characters")
public class CharacterResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final CharacterFacade FACADE =  CharacterFacade.getCharacterFacade(EMF);
    private static final Gson GSON = new Gson();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        List<Character> characters = FACADE.getAll();
        List<CharacterDTO> characterDTOS = CharacterDTO.getCharacterDTOs(characters);
        return GSON.toJson(characterDTOS);
    }

    @Path("{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCharacterById(@PathParam("name") String name) {
        Character character = FACADE.getCharacterByName(name);
        CharacterDTO characterDTO = new CharacterDTO(character);
        return GSON.toJson(characterDTO);
    }
}
