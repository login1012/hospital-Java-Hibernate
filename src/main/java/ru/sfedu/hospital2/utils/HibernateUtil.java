/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import ru.sfedu.hospital2.Constants;

public class HibernateUtil {
  private static SessionFactory sessionFactory;
  private static final String DEFAULT_CONFIG_PATH = Constants.DEFAULT_HIBERNATE_PATH;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      sessionFactory = new Configuration().configure(loadProperty()).buildSessionFactory();
    }

    return sessionFactory;
  }

  private static File loadProperty() {
    File nf;

    if (System.getProperty(Constants.HIBERNATE_PATH) != null) {
      nf = new File(System.getProperty(Constants.HIBERNATE_PATH));
    } else {
      nf = new File(DEFAULT_CONFIG_PATH);
    }

    return nf;
  }

}
