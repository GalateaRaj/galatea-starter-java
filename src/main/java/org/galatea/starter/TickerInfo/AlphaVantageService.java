package org.galatea.starter.TickerInfo;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class AlphaVantageService {

   private static String getURL(String ticker, int days){
       String s = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=";
       s+= ticker;
       s += "&apikey=90TJ7SQ2CNV9EHMF";
       return s;
   }
   public static Ticker getTicker(String ticker, int days){
       RestTemplate restTemplate = new RestTemplate();
       Ticker tickerdata = restTemplate.getForObject(AlphaVantageService.getURL(ticker,days), Ticker.class);
       return tickerdata;
   }

   public static String getDate(int i){

       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Calendar cal = Calendar.getInstance();
       cal.add(Calendar.DAY_OF_YEAR,i*-1);
       return dateFormat.format(cal.getTime());


   }

}
