package interfaces;

import java.util.List;
import model.Container;
import model.Customer;

public interface ContainerDao {
    void persistContainer(Container container);
    Container uploadContainer(String idDocker);
    List<Container> uploadAllContainer();
    List<Container> uploadAllContainerOfUser(Customer customer);
    public void modifyContainer(Container container);
    public void removeContainer(Container container);
}