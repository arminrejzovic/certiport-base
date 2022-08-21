package com.ematura.hello.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "certificate")
public class Certificate {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "supplierId", nullable = false)
    private Supplier supplier;

    @Column(name = "validFrom", nullable = false)
    private LocalDate validFrom;

    @Column(name = "validTo", nullable = false)
    private LocalDate validTo;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany()
    @JoinTable(
            name = "certificate_participation",
            joinColumns = @JoinColumn(name = "certificateId"),
            inverseJoinColumns = @JoinColumn(name = "workerId")
    )
    private List<Worker> participants = new ArrayList<>();

    @OneToMany(mappedBy = "certificate")
    private Set<Comment> comments = new LinkedHashSet<>();

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Worker> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Worker> participants) {
        this.participants = participants;
    }
}