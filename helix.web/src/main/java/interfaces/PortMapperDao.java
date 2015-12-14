package interfaces;
import model.PortMapper;
import model.User;

public interface PortMapperDao {
    public int getMaxPort();
    public void persistPortMapper(PortMapper portmapper);
}