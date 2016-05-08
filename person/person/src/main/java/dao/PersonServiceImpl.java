package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import dao.PersonDAOImpl;
import model.Person;
 
@Service
public class PersonServiceImpl 
{
     @Autowired
     PersonDAOImpl personService;
	Person pl;
  
  /*  public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }*/
 
    
    @Transactional
    public void addPerson(Person p) {
    	personService.addPerson(p);
    }
 
    
    @Transactional
    public void updatePerson(Person p) 
    {
    	personService.updatePerson(p);
        //this.updatePerson(p);
    }
 
    
    @Transactional
    public List<Person> listPersons()
    {
        return personService.listPersons(); 
    }
 
    
   // @Transactional
  /*  public Person getPersonById(int id)
    {
     
        		
    }*/
    @Transactional
    public void removePerson(int id) {
        personService.removePerson(id);
    }
 
}