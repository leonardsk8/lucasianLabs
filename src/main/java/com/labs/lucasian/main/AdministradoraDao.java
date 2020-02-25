package com.labs.lucasian.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;
import java.util.logging.Logger;

public class AdministradoraDao  {

    private SessionFactory sessionFactory;


    public AdministradoraDao() {
        sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
    }

    public void insertList(List<AdministradoraEntity> listEntities) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            listEntities.forEach(session::persist);
            transaction.commit();
        } catch (ConstraintViolationException cve) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error ocurrrido por llave duplicada, insertando en "
                    + listEntities.getClass());
        } catch (HibernateException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException e1) {
                    ;
                }
            }
            System.out.println("Error inesperado insertando " + listEntities.getClass());
            }
        }
    }
