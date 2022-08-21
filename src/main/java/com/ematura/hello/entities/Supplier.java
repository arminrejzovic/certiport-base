package com.ematura.hello.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "supplier")
@NamedQuery(name = Supplier.FILTER, query = "SELECT s FROM Supplier s WHERE s.name LIKE :name AND s.city LIKE :city")
public class Supplier {
    public static final String FILTER = "Supplier.filter";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "supplierIndex", nullable = false)
    private Integer supplierIndex;

    @OneToMany(mappedBy = "supplier")
    private Set<Certificate> certificates = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSupplierIndex() {
        return supplierIndex;
    }

    public void setSupplierIndex(Integer supplierIndex) {
        this.supplierIndex = supplierIndex;
    }

    public Set<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<Certificate> certificates) {
        this.certificates = certificates;
    }

}