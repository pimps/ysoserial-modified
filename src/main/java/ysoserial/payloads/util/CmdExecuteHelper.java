package ysoserial.payloads.util;

public class CmdExecuteHelper {
	
	private String terminalType;
	
	private String[] commandArray;
	
	private String command;

	public CmdExecuteHelper(String terminalType, String command) {
		super();
		this.terminalType = terminalType;
		this.command = command;
		
		switch (terminalType) {
		case "cmd":
			this.commandArray = new String[]{"cmd.exe","/c", command};
			break;
		case "bash":
			this.commandArray = new String[]{"/bin/bash","-c", command};
			break;
		case "powershell":
			this.commandArray = new String[]{"powershell.exe","-c", command};
			break;
		default:
			this.commandArray = new String[]{command};
			break;
		}
	}

	public String[] getCommandArray() {
		return commandArray;
	}

	public void setCommandArray(String[] commandArray) {
		this.commandArray = commandArray;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

}
