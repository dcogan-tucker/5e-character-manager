package com.sparta.dominic.dungeonsanddragons5echaractermanager.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "proficiencies", schema = "5e_character_manager")
public class ProficiencyEntity {
    private int proficiencyId;
    private String name;
    private Set<CharacterEntity> characters;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proficiency_id")
    public int getProficiencyId() {
        return proficiencyId;
    }

    public void setProficiencyId(int proficiencyId) {
        this.proficiencyId = proficiencyId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "proficiencies")
    public Set<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<CharacterEntity> characters) {
        this.characters = characters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProficiencyEntity that = (ProficiencyEntity) o;
        return Objects.equals(proficiencyId, that.proficiencyId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proficiencyId, name);
    }
}
