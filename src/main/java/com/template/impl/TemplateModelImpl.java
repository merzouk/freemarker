
package com.template.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.template.TemplateModel;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;

/**
 * A Renseigner.
 * @author  : admin
 * @project : freeMarker
 * @package : com.template.impl
 * @date    : 6 déc. 2015 01:29:48
 */
@Service("templateModel")
public class TemplateModelImpl implements TemplateModel
{
   private static final Logger logger = org.slf4j.LoggerFactory.getLogger( TemplateModelImpl.class );
   
   @Override
   public void createHtml( Map<String, Object> mapTemplateData, String ftlName, String htmlName, String directoryFtl, String versionTemplate )
   {
      logger.debug( "createHTML input" );
      create( mapTemplateData, ftlName, htmlName, directoryFtl, versionTemplate );
      logger.debug( "createHTML input" );
   }
   
   private void create( Map<String, Object> mapTemplateData, String ftlName, String htmlName, String directoryFtl, String versionTemplate )
   {
      logger.debug( "create begin" );
      Version version = new Version( versionTemplate, true, new Date() );
      /** Create and adjust the configuration */
      Configuration cfg = new Configuration( version );
      try
      {
         cfg.setDirectoryForTemplateLoading( new File( directoryFtl ) );
      }
      catch( IOException e )
      {
         logger.error( "Error ", e );
      }
      cfg.setObjectWrapper( new DefaultObjectWrapper( version ) );
      /** create a template */
      Template templateContent = null;
      try
      {
         templateContent = cfg.getTemplate( ftlName );
      }
      catch( TemplateNotFoundException e )
      {
         logger.error( "Error ", e );
      }
      catch( MalformedTemplateNameException e )
      {
         logger.error( "Error ", e );
      }
      catch( ParseException e )
      {
         logger.error( "Error ", e );
      }
      catch( IOException e )
      {
         logger.error( "Error ", e );
      }
      /** 
       * Merge data model with template 
       */
      Writer writer = null;
      try
      {
         writer = new FileWriter( htmlName );
      }
      catch( IOException e )
      {
         logger.error( "Error ", e );
      }
      try
      {
         templateContent.process( mapTemplateData, writer );
      }
      catch( TemplateException e )
      {
         logger.error( "Error ", e );
      }
      catch( IOException e )
      {
         logger.error( "Error ", e );
      }
      try
      {
         writer.flush();
      }
      catch( IOException e )
      {
         logger.error( "Error ", e );
      }
      String fileContent = loadFile( htmlName );
      logger.debug( fileContent );
      logger.debug( "create end" );
   }
   
   private String loadFile(String fileName)
   {
      BufferedReader br = null;
      String everything = null;
      try
      {
         br = new BufferedReader( new FileReader( fileName) );
      }
      catch( FileNotFoundException e )
      {
         logger.error( "Error ", e );
      }
      try
      {
         StringBuilder sb = new StringBuilder();
         String line = null;
         try
         {
            line = br.readLine();
         }
         catch( IOException e )
         {
            logger.error( "Error ", e );
         }
         while( line != null )
         {
            sb.append( line );
            sb.append( System.lineSeparator() );
            try
            {
               line = br.readLine();
            }
            catch( IOException e )
            {
               logger.error( "Error ", e );
            }
         }
        everything = sb.toString();
      }
      finally
      {
         try
         {
            br.close();
         }
         catch( IOException e )
         {
            logger.error( "Error ", e );
         }
      }
      return everything;
   }
}