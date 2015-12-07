package interfaces;

import java.util.List;

import model.Container;
import model.User;
import daoErrors.DAOException;

public interface ContainerDao {
    void persistContainer(Container container) throws DAOException;
    Container uploadContainer(int idContainer) throws DAOException;
    //type is either an admin or a customer
    List<Container> uploadAllContainer(User user) throws DAOException;
}