package de.lolmiCastHD.Reallife.Methoden;

import de.lolmiCastHD.Reallife.Main.Main;

public class Strings_Methoden 
{
	
	public static String prefix = Main.getInstance().getConfig().getString("Server.Prefix");
	public static String noperm = Main.getInstance().getConfig().getString("Server.Noperm");
	public static String errorCode = Main.getInstance().getConfig().getString("Server.ErrorCode");

}
