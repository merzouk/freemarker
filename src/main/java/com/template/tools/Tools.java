/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : freeMarker
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	Tools.java
 * Cree le 		: 	13 déc. 2015 à 01:03:36
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.template.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;

/**
 * A Renseigner.
 * @author  : admin
 * @project : freeMarker
 * @package : com.template.tools
 * @date    : 6 déc. 2015 01:35:48
 */
public class Tools
{
   private static final Logger logger = org.slf4j.LoggerFactory.getLogger( Tools.class );
   
   /**
    * 
    * @param dateStr
    * @param pattern
    * @return
    */
   public static int getDiffYear( String dateStr, String pattern )
   {
      Date birthDate = getDateFormat( dateStr, pattern );
      Date dateNow = new Date();
      Calendar calendarNow = new GregorianCalendar();
      calendarNow.setTime( dateNow );
      Calendar calendarBirth = new GregorianCalendar();
      calendarBirth.setTime( birthDate );
      int diffYear = calendarNow.get( Calendar.YEAR ) - calendarBirth.get( Calendar.YEAR );
      //int diffMonth = diffYear * 12 + calendarBirth.get(Calendar.MONTH) - calendarNow.get(Calendar.MONTH);
      return diffYear;
   }
   
   /**
    * 
    * @param dateStr
    * @param pattern
    * @return
    */
   public static Date getDateFormat( String dateStr, String pattern )
   {
      SimpleDateFormat format = new SimpleDateFormat( pattern );
      Date date = null;
      try
      {
         date = format.parse( dateStr );
      }
      catch( Exception e )
      {
         logger.error( "Error during date : ", e );
      }
      return date;
   }
   
   /**
    * 
    * @param date
    * @param pattern
    * @return
    */
   public static String getDateString( Date date, String pattern )
   {
      /**
       *  Create an instance of SimpleDateFormat used for formatting the string representation of date (day/month/year)
       */
      DateFormat df = new SimpleDateFormat( pattern );
      /**
       *  Using DateFormat format method we can create a string representation of a date with the defined format.
       */
      String dateStr = df.format( date );
      return dateStr;
   }
}
