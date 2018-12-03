
try{
	// create url 
	URL url = new URL("https://www.ndbc.noaa.gov/data/latest_obs/latest_obs.txt");
	String line; 
	BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

	while ((line = in.readLine()) != null){
		String[] splited = str.trim().replaceAll(" +", " ").split(" ");
		String sDate1 = splited[3] + "/" + splited[4] + "/" + splited[5]
			+ "/" + splited[6] + "/" + splited[7];

	try{
		java.util.Date date1 = new
		java.text.SimpleDateFormat("yyyy/MM/dd/hh/mm").parse(sDate1);
	}

	catch(Exception e){
		System.out.println(e.getMessage());
	}

	String stationId = splited[0];
	String latLon = splited[1] + "," + splited[2]; //format: lat, lon
	String windSpeed = splited[9];
	String waveHeight = splited[11];
	String airTemperature = splited[17];
	String waterTemperature = splited[18];

	if(windSpeed.toLowerCase().equals("mm")){
		String windSpeed = "Data N/A";
	}
	if(waveHeight.toLowerCase().equals("mm")){
		String waveHeight = "Data N/A";
	}
	if(airTemperature.toLowerCase().equals("mm")){
		String airTemperature = "Data N/A";
	}
	if(waterTemperature.toLowerCase().equals("mm")){
		String waterTemperature = "Data N/A";
	}

	}
	in.close();
}
catch (MalformedURLException e){	
}
catch (IOException e){
}
