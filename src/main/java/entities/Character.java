package entities;

import dtos.CharacterDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "characters")
@NamedQuery(name = "Character.deleteAllRows", query = "DELETE from Character")
public class Character implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "image")
    private String imageSource;

    //TODO: minPlayers, max, abbilities
    @NotNull
    @Column(name = "minplayers")
    private int minPlayers;

    @NotNull
    @Column(name = "max")
    private int max;

    @NotNull
    @Column(name = "ability")
    private String ability;


    public Character() {
    }

    public Character(String name, String description, String imageSource, int minPlayers, int max, String ability) {
        this.name = name;
        this.description = description;
        this.imageSource = imageSource;
        this.minPlayers = minPlayers;
        this.max = max;
        this.ability = ability;
    }

    public Character(CharacterDTO characterDTO) {
        this.name = characterDTO.getName();
        this.description = characterDTO.getDescription();
        this.imageSource = characterDTO.getImageSource();
        this.minPlayers = characterDTO.getMinPlayers();
        this.max = characterDTO.getMax();
        this.ability = characterDTO.getAbility();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}
