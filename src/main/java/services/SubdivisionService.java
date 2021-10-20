package services;

import dao.SubdivisionDao;
import tables.Employee;
import tables.Subdivision;

import java.util.List;

public class SubdivisionService {
    private SubdivisionDao subdivisionDao = new SubdivisionDao();

    public SubdivisionService() {
    }

    public Subdivision findSubdivision(int id) {
        return subdivisionDao.findById(id);
    }

    public void saveSubdivision(Subdivision subdivision) {
        subdivisionDao.save(subdivision);
    }

    public void deleteSubdivision(Subdivision subdivision) {
        subdivisionDao.delete(subdivision);
    }

    public void updateSubdivision(Subdivision subdivision) {
        subdivisionDao.update(subdivision);
    }

    public List<Subdivision> findAllUsers() {
        return subdivisionDao.findAll();
    }

    public Employee findEmployeeById(int id) {
        return subdivisionDao.findEmployeeById(id);
    }

    public List<Subdivision> findByName(String s) {
        return subdivisionDao.findByName(s);
    }

    public List<Subdivision> findByContactDetails(String s) {
        return subdivisionDao.findByContactDetails(s);
    }

    public List<Subdivision> findByManager(String s) {
        return subdivisionDao.findByManager(s);
    }

}
