package org.util;

import java.util.List;

public class BlockUtil {

	/**
	 * 将经纬度字符串转化为5位区域方格字符串
	 * 
	 * @param latLng
	 * @return
	 */
	public static String getBlockCode5(String latLng) {
		String[] splitLatLng = latLng.split(",|，");
		double lng = Double.parseDouble(splitLatLng[0]);
		double lat = Double.parseDouble(splitLatLng[1]);
		return new GeoHash(lat, lng, 20, 20).getGeoHashBase32().substring(0, 5);
	}

	/**
	 * 将经纬度字符串转化为6位区域方格字符串
	 * 
	 * @param latLng
	 * @return
	 */
	public static String getBlockCode(String latLng) {
		String[] splitLatLng = latLng.split(",|，");
		double lng = Double.parseDouble(splitLatLng[0]);
		double lat = Double.parseDouble(splitLatLng[1]);
		return new GeoHash(lat, lng, 20, 20).getGeoHashBase32().substring(0, 6);
	}

	/**
	 * 将经纬度转化为6位区域方格字符串及其附近八格方格字符串的列表
	 * 
	 * @param latLng
	 * @return
	 */
	public static List<String> getBlockCodeFor9(String latLng) {
		String[] splitLatLng = latLng.split(",|，");
		double lng = Double.parseDouble(splitLatLng[0]);
		double lat = Double.parseDouble(splitLatLng[1]);
		GeoHash gh = new GeoHash(lat, lng, 15, 15);
		return gh.getGeoHashBase32For9();
	}

	/**
	 * 将经纬度字符串转化为7位区域方格字符串
	 * 
	 * @param latLng
	 * @return
	 */
	public static String getBlockCode7(String latLng) {
		String[] splitLatLng = latLng.split(",|，");
		double lng = Double.parseDouble(splitLatLng[0]);
		double lat = Double.parseDouble(splitLatLng[1]);
		return new GeoHash(lat, lng, 20, 20).getGeoHashBase32().substring(0, 7);
	}

	/**
	 * 将经纬度字符串转化为8位区域方格字符串
	 * 
	 * @param latLng
	 * @return
	 */
	public static String getBlockCode8(String latLng) {
		String[] splitLatLng = latLng.split(",|，");
		double lng = Double.parseDouble(splitLatLng[0]);
		double lat = Double.parseDouble(splitLatLng[1]);
		return new GeoHash(lat, lng, 20, 20).getGeoHashBase32();
	}

	/**
	 * 将经纬度转化为6位区域方格字符串
	 * 
	 * @param latLng
	 * @return
	 */
	public static String getBlockCode(double lat, double lng) {
		return new GeoHash(lat, lng, 20, 20).getGeoHashBase32().substring(0, 6);
	}

}
