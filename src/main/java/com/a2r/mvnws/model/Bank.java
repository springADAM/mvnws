package com.a2r.mvnws.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "banque")
public class Bank {

    @Id
    private Long nbanque;
    private float ncompte, ncompteeuro;

    public Bank() {

    }

    public Bank(Long nbanque, float ncompte, float ncompteeuro) {
        this.nbanque = nbanque;
        this.ncompte = ncompte;
        this.ncompteeuro = ncompteeuro;
    }

    public Long getNbanque() {
        return nbanque;
    }

    public void setNbanque(Long nbanque) {
        this.nbanque = nbanque;
    }

    public float getNcompte() {
        return ncompte;
    }

    public void setNcompte(float ncompte) {
        this.ncompte = ncompte;
    }

    public float getNcompteeuro() {
        return ncompteeuro;
    }

    public void setNcompteeuro(float ncompteeuro) {
        this.ncompteeuro = ncompteeuro;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "nbanque=" + nbanque +
                ", ncompte=" + ncompte +
                ", ncompteeuro=" + ncompteeuro +
                '}';
    }
}
