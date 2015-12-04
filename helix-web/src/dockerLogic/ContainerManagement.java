package dockerLogic;

import model.Container;

public interface ContainerManagement {
	public void createContainer(Container container);
	public int startContainer(Container container);
	public int stopContainer(Container container);
	public int deleteContainer(Container container);
	public int pauseContainer(Container container);
	public int unpauseContainer(Container container);
}
