package interfaces;

import model.PortMapper;

public interface PortMapperDao {
    public int getMaxPort();
    public void persistPortMapper(PortMapper portmapper);
}