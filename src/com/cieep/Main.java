package com.cieep;

import com.cieep.modelos.Alumno;
import com.cieep.modelos.Curso;
import com.cieep.modelos.Equipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alumno alumno = new Alumno("Yeffry", "Pastrana", "12345678Z");
        Curso curso = new Curso("DAM", "POR CULEROS", 'C');
        Equipo equipo = new Equipo("Apple", "iMac 21");

        alumno.setEquipo(equipo);
        alumno.setCurso(curso);
        curso.getAlumnos().add(alumno);
        equipo.setAlumno(alumno);

        // CREA LA VARIABLE QUE PUEDE CONECTAR
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // LA VARIBLE DE LA CONEXiÓN
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // CREATE
        session.persist(alumno);
        session.persist(curso);
        session.persist(equipo);

        session.getTransaction().commit();

//        // READ
//        Alumno a = session.get(Alumno.class, 2);
//        System.out.println(a.toString());
//
//        // UPDATE
//        a.setName("Eduard");
//        session.merge(a);
//
//        // DELETE
//       // session.remove(a);


        session.close();
    }
}