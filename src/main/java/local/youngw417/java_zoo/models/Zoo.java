package local.youngw417.java_zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "zoos")
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @Column(nullable = false, unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private List<Telephone> telephones = new ArrayList<>();

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Set<Zooanimals> animals = new HashSet<>();


    public Zoo() {
    }
    public Zoo(String zooname) {
        this.zooname = zooname;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Set<Zooanimals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Zooanimals> animals) {
        this.animals = animals;
    }
}

