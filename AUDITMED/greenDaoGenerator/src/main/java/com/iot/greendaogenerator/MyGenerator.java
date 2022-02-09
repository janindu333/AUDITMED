package com.iot.greendaogenerator;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {

    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.iot.panel.db");
        // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();
        addTables(schema);
        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addFormOneData(schema);
    }

    private static Entity addFormOneData(final Schema schema) {
        Entity formOne = schema.addEntity("FormOne");
        formOne.addIdProperty().primaryKey().autoincrement();
        formOne.addStringProperty("source");
        formOne.addStringProperty("numero_de_compteur");
        formOne.addStringProperty("calibre");
        formOne.addStringProperty("mode_de_pose");
        formOne.addStringProperty("dimension");
        formOne.addStringProperty("etat_de_lenvelope");
        formOne.addStringProperty("type_d_envelope");
        formOne.addStringProperty("ip");

        formOne.addStringProperty("type_de_protection_generale");
        formOne.addStringProperty("etat_de_protection");
        formOne.addStringProperty("nombre_de_contacteur");
        formOne.addStringProperty("etat_de_contacteur");
        formOne.addStringProperty("type_de_commande");

        formOne.addStringProperty("nombre_de_depart");
        formOne.addStringProperty("protection_de_depart");
        formOne.addStringProperty("tension");
        return formOne;
    }

}