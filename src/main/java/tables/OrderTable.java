package tables;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_id")
    private int Order_id;
    private String Subject_of_order;
    private String Deadline;
    private String Sign_of_control;
    private String Sign_of_execution;
    private String Text_of_order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Author", insertable = false, updatable = false)
    private Employee author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Executor", insertable = false, updatable = false)
    private Employee executor;

    public OrderTable() {}

    public OrderTable(String subject_of_order, Employee author, Employee executor, String deadline, String sign_of_control, String sign_of_execution, String text_of_order) {
        Subject_of_order = subject_of_order;
        Deadline = deadline;
        Sign_of_control = sign_of_control;
        Sign_of_execution = sign_of_execution;
        Text_of_order = text_of_order;
        this.author = author;
        this.executor = executor;
        this.author.getOrdersAuthorList().add(this);
        this.executor.getOrdersExecutorList().add(this);
    }

    public int getOrder_id() { return Order_id; }

    public String getSubject_of_order() { return Subject_of_order; }

    public Employee getAuthor() { return this.author; }

    public Employee getExecutor() { return this.executor; }

    public String getDeadline() { return Deadline; }

    public String getSign_of_control() { return Sign_of_control; }

    public String getSign_of_execution() { return Sign_of_execution; }

    public String getText_of_order() { return Text_of_order; }

    public void setSubject_of_order(String subject_of_order) { Subject_of_order = subject_of_order; }

    public void setAuthor(Employee author) {
        if (this.author != null) {
            this.author.removeAuthor(this);
        }
        this.author = author;
        this.author.getOrdersAuthorList().add(this);
    }

    public void setExecutor(Employee executor) {
        if (this.executor != null) {
            this.executor.removeExecutor(this);
        }
        this.executor = executor;
        this.executor.getOrdersExecutorList().add(this);
    }

    public void setDeadline(String deadline) { Deadline = deadline; }

    public void setSign_of_control(String sign_of_control) { Sign_of_control = sign_of_control; }

    public void setSign_of_execution(String sign_of_execution) { Sign_of_execution = sign_of_execution; }

    public void setText_of_order(String text_of_order) { Text_of_order = text_of_order; }
}
