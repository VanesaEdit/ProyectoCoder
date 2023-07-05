package com.example.demo.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false) //Esto lo que hace es obligar a que contengan un valor y no se muestre como "null".
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String docnumber;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Invoice> invoice;

    //RESTO DE LOS METODOS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber='" + docnumber + '\'' +
                '}';
    }
}
