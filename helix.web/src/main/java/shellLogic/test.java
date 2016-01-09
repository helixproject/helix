package shellLogic;

public class test {

	public static void main(String[] args) {

		String[] commands = {"/bin/sh","-c","docker stats --no-stream=true 3a895df2294d | sed -n 2p"};
		String[] result = ShellManager.execOnShell(commands);
		String output = result[0] ;
		String[] stats = output.split("\\s+");
		
		//id
		System.out.println(stats[0]);
		//cpu %
		System.out.println(stats[1]);
		// mem usage
		System.out.println(stats[2]);
		// mem usage unit
		System.out.println(stats[3]);
		// mem limit
		System.out.println(stats[5]);
		// mem limit unit
		System.out.println(stats[6]);
		// mem %
		System.out.println(stats[7]);
	}

}
