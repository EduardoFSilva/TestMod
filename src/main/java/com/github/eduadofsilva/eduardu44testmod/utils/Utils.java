package com.github.eduadofsilva.eduardu44testmod.utils;

public class Utils {
	public static String getModNamespacedId(String id) {
		return getNamespacedId(Constantes.MOD_ID, id);
	}
	public static String getNamespacedId(String modid, String id) {
		return String.format("%s:%s", modid,id);
	}
}
