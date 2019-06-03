package app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.User;

public class AddUserMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("jpastart");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction(); // get new transaction

        try {
            transaction.begin();
            User user = doBizLogic();
            entityManager.persist(user);
            transaction.commit();

            User foundUser = entityManager.find(User.class, user.getEmail());
            assert(foundUser != null);
            assert(foundUser.getEmail().equals(user.getEmail()));
        } catch (Exception e) {
            // FIXME: replace logging
            System.out.println("Fail to create a user, cause: " + e.getMessage());
            transaction.rollback();
        } finally {
            entityManager.close();

        }
        entityManagerFactory.close();
    }

    private static User doBizLogic() {
        return new User("user@user.com", "user1", new Date());
    }

}
