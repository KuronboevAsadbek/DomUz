package uz.DomUz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "inn")
    private String inn;

    @Column(name = "jshshir")
    private String jshshir;

    @Column(name = "home_number")
    private String homeNumber;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "deal_number")
    private String dealNumber;

    @Column(name = "deal_date")
    private String dealDate;

    @Column(name = "room")
    private String room;

    @Column(name = "cost_one_square")
    private String costOneSquare;

    @Column(name = "square")
    private String square;

    @Column(name = "total_amount")
    private String totalAmount;

    @Column(name = "after_pay_amount")
    private String afterPayAmount;

    @Column(name = "initila_payment")
    private String initialPayment;

    @Column(name = "marriage")
    private String marriage;

    @Column(name = "entrance_number")
    private String entranceNumber;

    @Column(name = "floor")
    private String floor;

    @ManyToOne
    private Housing housing;


}

