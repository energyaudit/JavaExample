package main.Java2.Json;/*
 * This file is part of Weather web-service call.
 * Weather web-service call is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation.
 *
 * Weather web-service call is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.  <http://www.gnu.org/licenses/>
 *
 * Author(s):
 * © 2015 Kasra Madadipouya <kasra@madadipouya.com>
 */

import java.util.Map.Entry;
import java.util.TreeMap;

public class CallWebservice {
	public static void main(String[] args) {
		Parser parser =  new Parser();
		parser.parse(args);
		WeatherForecast wfc = new WeatherForecast();
		TreeMap <String,String> results;
		if(parser.has(Parser.QUERY)) {
			results = wfc.getWeather(true);
		}else {
			results = wfc.getWeather();
		}
		for (Entry<String, String> entry : results.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.printf("%s : %s\n", key, value);
		}
	}
}
