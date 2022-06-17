package app.domain.shared;

import app.domain.model.systemUser.Employee;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    final static String FILE_SNSUSER = "snsusers.bin";
    final static String FILE_EMPLOYEES = "employees.bin";
    final static String FILE_VACCINATIONCENTER = "vaccinationcenters.bin";

    public boolean saveSNSUsers(List<SNSUser> list) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_SNSUSER));
            try {
                out.writeObject(list);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean saveEmployees(List<Employee> list) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_EMPLOYEES));
            try {
                out.writeObject(list);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean saveVaccinationCenters(List<VaccinationCenter> list) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_VACCINATIONCENTER));
            try {
                out.writeObject(list);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public List<SNSUser> readSNSUsers() {
        List<SNSUser> list;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_SNSUSER));
            try {
                list = (List<SNSUser>) in.readObject();
            } finally {
                in.close();
            }
            return list;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Employee> readEmployes() {
        List<Employee> list;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_EMPLOYEES));
            try {
                list = (List<Employee>) in.readObject();
            } finally {
                in.close();
            }
            return list;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<VaccinationCenter> readVaccinationCenters() {
        List<VaccinationCenter> list;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_VACCINATIONCENTER));
            try {
                list = (List<VaccinationCenter>) in.readObject();
            } finally {
                in.close();
            }
            return list;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
