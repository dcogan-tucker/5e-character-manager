package com.sparta.dominic.dungeonsanddragons5echaractermanager.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "characters", schema = "5e_character_manager")
public class CharacterEntity {
    private int characterId;
    private String name;
    private String race;
    private String characterClass;
    private UserEntity user;
    private Set<ProficiencyEntity> proficiencies;
    private Set<TraitEntity> traits;

    @Id
    @Column(name = "character_id")
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "race")
    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Basic
    @Column(name = "class")
    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "character_proficiencies",
        joinColumns = {
            @JoinColumn(name = "character_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "proficiency_id")
        })
    public Set<ProficiencyEntity> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(Set<ProficiencyEntity> proficiencies) {
        this.proficiencies = proficiencies;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "character_traits",
            joinColumns = {
                    @JoinColumn(name = "character_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "trait_id")
            })
    public Set<TraitEntity> getTraits() {
        return traits;
    }

    public void setTraits(Set<TraitEntity> traits) {
        this.traits = traits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterEntity that = (CharacterEntity) o;
        return Objects.equals(characterId, that.characterId) && Objects.equals(name, that.name) && Objects.equals(race, that.race) && Objects.equals(characterClass, that.characterClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, name, race, characterClass);
    }
}
