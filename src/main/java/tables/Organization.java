package tables;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Organization_id;
    private String Organization_name;
    private String Physical_adress;
    private String Legal_adress;
    private String Director;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subdivision> subdivisionList;

    public Organization() {
    }

    public Organization(String name, String physical_adress, String legal_adress, String director) {
        Organization_name = name;
        Physical_adress = physical_adress;
        Legal_adress = legal_adress;
        Director = director;
        this.subdivisionList = new ArrayList<>();
    }

    public void addSubdivision(Subdivision subdivision) {
        subdivision.setOrganization(this);
        this.subdivisionList.add(subdivision);
    }

    public void removeSubdivisions(Subdivision subdivision) {
        subdivisionList.remove(subdivision);
    }

    @Override
    public String toString() {
        return ("Id : " + this.Organization_id +
        " Physical_adress : " + this.Physical_adress +
        " Legal_adress : " + this.Legal_adress +
        " Director : " + this.Director);
    }

    public int getId() {
        return Organization_id;
    }

    public String getOrganization_name() {
        return Organization_name;
    }

    public String getPhysical_adress() {
        return Physical_adress;
    }

    public String getLegal_adress() {
        return Legal_adress;
    }

    public String getDirector() {
        return Director;
    }

    public List<Subdivision> getSubdivisionList() {
        return subdivisionList;
    }

    public void setOrganization_name(String organization_name) {
        Organization_name = organization_name;
    }

    public void setPhysical_adress(String physical_adress) {
        Physical_adress = physical_adress;
    }

    public void setLegal_adress(String legal_adress) {
        Legal_adress = legal_adress;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setSubdivisionList(List<Subdivision> subdivisionList) {
        this.subdivisionList = subdivisionList;
    }
}
