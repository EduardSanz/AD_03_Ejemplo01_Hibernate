package com.cieep;

import com.cieep.modelos.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alumno alumno = new Alumno("Edu", "Sanz", "12345678Z");
        // CREA LA VARIABLE QUE PUEDE CONECTAR
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // LA VARIBLE DE LA CONEXiÓN
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // CREATE
        session.persist(alumno);

        session.getTransaction().commit();

        session.beginTransaction();
        // READ
        Alumno a = session.get(Alumno.class, 2);
        System.out.println(a.toString());

        // UPDATE
        a.setName("Eduard");
        session.merge(a);

        // DELETE
       // session.remove(a);

        session.getTransaction().commit();
        session.close();
    }
}