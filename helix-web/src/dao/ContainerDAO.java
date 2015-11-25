package dao;

import java.util.List;
import model.Container;

public interface ContainerDAO {

    List<Container> findAll();
    List<Container> findById();
    List<Container> findByName();
    boolean insertContainer(Container container);
    boolean updateContainer(Container container);
    boolean deleteContainer(Container container);
}