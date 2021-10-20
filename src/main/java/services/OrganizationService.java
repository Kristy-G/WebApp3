package services;

import dao.OrganizationDao;
import tables.Organization;
import tables.Subdivision;

import java.util.List;

public class OrganizationService {
    private OrganizationDao organizationDao = new OrganizationDao();

    public OrganizationService() {
    }

    public Organization findOrganizationById(int id) {
        return organizationDao.findById(id);
    }

    public void saveOrganization(Organization organization) {
        organizationDao.save(organization);
    }

    public void deleteOrganization(Organization organization) {
        organizationDao.delete(organization);
    }

    public void updateOrganization(Organization organization) {
        organizationDao.update(organization);
    }

    public List<Organization> findAllOrganizations() {
        return organizationDao.findAll();
    }

    public Subdivision findSubdivisionById(int id) {
        return organizationDao.findSubdivisionById(id);
    }

    public List<Organization> findByName(String s) {
        return organizationDao.findByName(s);
    }

    public List<Organization> findByAdress(String s) {
        return organizationDao.findByAdress(s);
    }

    public List<Organization> findByLegalAdress(String s) {
        return organizationDao.findByLegalAdress(s);
    }

    public List<Organization> findByDirector(String s) {
        return organizationDao.findByDirector(s);
    }
}
