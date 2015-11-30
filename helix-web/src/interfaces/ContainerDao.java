package interfaces;

import daoErrors.DAOException;
import model.Container;

public interface ContainerDao {
    void persistContainer(Container container) throws DAOException;
    Container uploadContainer(int idContainer) throws DAOException;
}