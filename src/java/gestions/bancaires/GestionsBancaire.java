/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestions.bancaires;

import comptes.bancaires.CompteBancaire;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MOHAMED
 */
@Stateless
public class GestionsBancaire {

     @PersistenceContext
    private EntityManager em;
   /* @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*", second = "0", persistent = false)
    
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }
*/

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     
     public void creerCompteDeTest() {
         
       creeCompte("KEITA", "Mamady", "15-gh",10000);
       creeCompte("KEITA2", "Mamady2", "15-ghj",20000);
       creeCompte("KEITA3", "Mamady3", "15-ghf",30000);
       
    }
     
     public CompteBancaire creeCompte(String fisrtname, String lastname, String account,double balance) {
        CompteBancaire c = new CompteBancaire(fisrtname, lastname,account,balance);
        em.persist(c);
        return c;
    }
     
     public Collection<CompteBancaire> getAllComptes() {
        // Exécution d'une requête équivalente à un select *
        Query q = em.createQuery("select u from Compte u");
        return q.getResultList();
    }
}
