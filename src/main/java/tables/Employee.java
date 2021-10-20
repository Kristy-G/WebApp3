package tables;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_id")
    private int Employee_id;
    private String Surname;
    private String Name;
    private String Second_name;
    private String Position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Subdivision_id", insertable = false, updatable = false)
    private Subdivision subdivision;

    @OneToMany(mappedBy = "author")
    private List<OrderTable> ordersAuthorList;

    @OneToMany(mappedBy = "executor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderTable> ordersExecutorList;

    public Employee() {
    }

    public Employee(String surname, String name, String second_name, String position, Subdivision subdivision) {
        Surname = surname;
        Name = name;
        Second_name = second_name;
        Position = position;
        this.subdivision = subdivision;
        this.ordersAuthorList = new ArrayList<>();
        this.ordersExecutorList = new ArrayList<>();
        subdivision.addEmployee(this);
    }

    public void removeAuthor (OrderTable author) {
        ordersAuthorList.remove(author);
    }

    public void removeExecutor (OrderTable executor) {
        ordersExecutorList.remove(executor);
    }

    public int getEmployee_id() {
        return Employee_id;
    }

    public String getSurname() {
        return Surname;
    }

    public String getName() {
        return Name;
    }

    public String getSecond_name() {
        return Second_name;
    }

    public String getPosition() {
        return Position;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public List<OrderTable> getOrdersAuthorList() {
        return ordersAuthorList;
    }

    public List<OrderTable> getOrdersExecutorList() {
        return ordersExecutorList;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) { Name = name; }

    public void setSecond_name(String second_name) { Second_name = second_name; }

    public void setPosition(String position) { Position = position; }

    public void setSubdivision(Subdivision subdivision) {
        if (this.subdivision != null) {
            this.subdivision.removeEmployee(this);
        }
        this.subdivision = subdivision;
        subdivision.addEmployee(this);
    }

    public void setOrdersAuthorList(List<OrderTable> ordersAuthorList) { this.ordersAuthorList = ordersAuthorList; }

    public void setOrdersExecutorList(List<OrderTable> ordersExecutorList) { this.ordersExecutorList = ordersExecutorList; }
}
