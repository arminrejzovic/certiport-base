package com.ematura.hello.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "certificate_participation")
public class CertificateParticipation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificateId")
    private Certificate certificate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    //TODO [JPA Buddy] generate columns from DB
}