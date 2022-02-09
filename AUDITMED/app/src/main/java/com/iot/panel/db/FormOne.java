package com.iot.panel.db;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "FORM_ONE".
 */
@Entity
public class FormOne {

    @Id(autoincrement = true)
    private Long id;
    private String source;
    private String numero_de_compteur;
    private String calibre;
    private String mode_de_pose;
    private String dimension;
    private String etat_de_lenvelope;
    private String type_d_envelope;
    private String ip;
    private String type_de_protection_generale;
    private String etat_de_protection;
    private String nombre_de_contacteur;
    private String etat_de_contacteur;
    private String type_de_commande;
    private String nombre_de_depart;
    private String protection_de_depart;
    private String tension;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated(hash = 1022754193)
    public FormOne() {
    }

    public FormOne(Long id) {
        this.id = id;
    }

    @Generated(hash = 1093931783)
    public FormOne(Long id, String source, String numero_de_compteur, String calibre, String mode_de_pose, String dimension, String etat_de_lenvelope, String type_d_envelope, String ip, String type_de_protection_generale, String etat_de_protection, String nombre_de_contacteur, String etat_de_contacteur, String type_de_commande, String nombre_de_depart, String protection_de_depart, String tension) {
        this.id = id;
        this.source = source;
        this.numero_de_compteur = numero_de_compteur;
        this.calibre = calibre;
        this.mode_de_pose = mode_de_pose;
        this.dimension = dimension;
        this.etat_de_lenvelope = etat_de_lenvelope;
        this.type_d_envelope = type_d_envelope;
        this.ip = ip;
        this.type_de_protection_generale = type_de_protection_generale;
        this.etat_de_protection = etat_de_protection;
        this.nombre_de_contacteur = nombre_de_contacteur;
        this.etat_de_contacteur = etat_de_contacteur;
        this.type_de_commande = type_de_commande;
        this.nombre_de_depart = nombre_de_depart;
        this.protection_de_depart = protection_de_depart;
        this.tension = tension;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNumero_de_compteur() {
        return numero_de_compteur;
    }

    public void setNumero_de_compteur(String numero_de_compteur) {
        this.numero_de_compteur = numero_de_compteur;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getMode_de_pose() {
        return mode_de_pose;
    }

    public void setMode_de_pose(String mode_de_pose) {
        this.mode_de_pose = mode_de_pose;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getEtat_de_lenvelope() {
        return etat_de_lenvelope;
    }

    public void setEtat_de_lenvelope(String etat_de_lenvelope) {
        this.etat_de_lenvelope = etat_de_lenvelope;
    }

    public String getType_d_envelope() {
        return type_d_envelope;
    }

    public void setType_d_envelope(String type_d_envelope) {
        this.type_d_envelope = type_d_envelope;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType_de_protection_generale() {
        return type_de_protection_generale;
    }

    public void setType_de_protection_generale(String type_de_protection_generale) {
        this.type_de_protection_generale = type_de_protection_generale;
    }

    public String getEtat_de_protection() {
        return etat_de_protection;
    }

    public void setEtat_de_protection(String etat_de_protection) {
        this.etat_de_protection = etat_de_protection;
    }

    public String getNombre_de_contacteur() {
        return nombre_de_contacteur;
    }

    public void setNombre_de_contacteur(String nombre_de_contacteur) {
        this.nombre_de_contacteur = nombre_de_contacteur;
    }

    public String getEtat_de_contacteur() {
        return etat_de_contacteur;
    }

    public void setEtat_de_contacteur(String etat_de_contacteur) {
        this.etat_de_contacteur = etat_de_contacteur;
    }

    public String getType_de_commande() {
        return type_de_commande;
    }

    public void setType_de_commande(String type_de_commande) {
        this.type_de_commande = type_de_commande;
    }

    public String getNombre_de_depart() {
        return nombre_de_depart;
    }

    public void setNombre_de_depart(String nombre_de_depart) {
        this.nombre_de_depart = nombre_de_depart;
    }

    public String getProtection_de_depart() {
        return protection_de_depart;
    }

    public void setProtection_de_depart(String protection_de_depart) {
        this.protection_de_depart = protection_de_depart;
    }

    public String getTension() {
        return tension;
    }

    public void setTension(String tension) {
        this.tension = tension;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}