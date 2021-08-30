/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5;

import ru.sfedu.hospital2.lab5.model.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Liza
 */


public interface IProvider {

  Optional<List<Employee>> selectAllEmployee();

  Optional<List<Patient>> selectAllPatient();

  Optional<List<Appointment>> selectAllAppointment();

  Optional<List<Hospital>> selectAllHospital();

}
