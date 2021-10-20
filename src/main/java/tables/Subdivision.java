package tables;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subdivisions")
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Subdivision_id")
    private int Subdivision_id;
    private String Subdivision_name;
    private String Contact_details;
    private String Manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Organization_id", insertable = false, updatable = false)
    private Organization organization;

    @OneToMany(mappedBy = "subdivision", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;

    public Subdivision() {
    }

    public Subdivision(String subdivision_name, String contact_details, String manager, Organization organization) {
        this.Subdivision_name = subdivision_name;
        this.Contact_details = contact_details;
        this.Manager = manager;
        this.organization = organization;
        this.employeeList = new ArrayList<>();
        organization.addSubdivision(this);
    }

    public void addEmployee(Employee employee) {
        employee.setSubdivision(this);
        this.employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public int getId() {
        return Subdivision_id;
    }

    public String getSubdivision_name() {
        return Subdivision_name;
    }

    public String getContact_details() { return Contact_details; }

    public String getManager() {
        return Manager;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setSubdivision_name(String subdivision_name) {
        Subdivision_name = subdivision_name;
    }

    public void setContact_details(String contact_details) {
        Contact_details = contact_details;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public void setOrganization(Organization organization) {
        if (this.organization != null) {
            this.organization.removeSubdivisions(this);
        }
        this.organization = organization;
        organization.addSubdivision(this);
    }
}
