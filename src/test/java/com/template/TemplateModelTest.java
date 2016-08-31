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
 * Fichier 		:	CreateHtmlTest.java
 * Cree le 		: 	6 déc. 2015 à 00:44:35
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.template;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.template.TemplateModel;
import com.template.model.Person;
import com.template.tools.Tools;

/**
 * A Renseigner.
 * @author  : admin
 * @project : freeMarker
 * @package : com.template
 * @date    : 6 déc. 2015 02:44:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContextTest.xml")
public class TemplateModelTest
{
   private static final Logger logger = org.slf4j.LoggerFactory.getLogger( TemplateModelTest.class );
   
   @Autowired
   private TemplateModel       templateModel;
   
   @Test
   public void createHTMLTest()
   {
      logger.info( "createHTMLTest input" );
      String pattern = "dd/MM/yyyy";
      assertNotNull( templateModel );
      List<Person> listPerson = new LinkedList<Person>();
      String ryanDate = "25/04/2012";
      listPerson.add( new Person( "MM", "Rm", "r@email.com", Tools.getDiffYear( ryanDate, pattern ) ) );
      String assiaDate = "28/08/1979";
      listPerson.add( new Person( "MM", "As", "ma@email.com", Tools.getDiffYear( assiaDate, pattern ) ) );
      String merzoukDate = "20/11/1972";
      listPerson.add( new Person( "MM", "Mrk", "mrk@email.com", Tools.getDiffYear( merzoukDate, pattern ) ) );
      /** Create a data model */
      Map<String, Object> mapTemplateData = new HashMap<String, Object>();
      mapTemplateData.put( "listPerson", listPerson );
      mapTemplateData.put( "titre_liste", "Person's list" );
      mapTemplateData.put( "date_du_jour", Tools.getDateString( new Date(), "dd/MM/yyyy HH:mm:ss" ) );
      templateModel.createHtml( mapTemplateData, "listPersonne.ftl", "listPerson.html", "src/templates", "2.3.0" );
      logger.info( "createHTMLTest output" );
   }
   
   @Test
   public void createHTMLListeVideTest()
   {
      logger.info( "createHTMLListeVideTest input" );
      assertNotNull( templateModel );
      List<Person> listPerson = new LinkedList<Person>();
      Map<String, Object> mapTemplateData = new HashMap<String, Object>();
      mapTemplateData.put( "listPerson", listPerson );
      templateModel.createHtml( mapTemplateData, "listPersonne.ftl", "listPersonVide.html", "src/templates", "2.3.0" );
      logger.info( "createHTMLListeVideTest output" );
   }
   
   @Before
   public void init()
   {
      logger.info( "init" );
   }
   
   @After
   public void destroy()
   {
      logger.info( "destroy" );
      templateModel = null;
      assertNull( templateModel );
   }
}