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
 * Fichier 		:	TemplateImpl.java
 * Cree le 		: 	6 déc. 2015 à 01:26:48
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package com.template;

import java.util.Map;

/**
 * A Renseigner.
 * @author  : admin
 * @project : freeMarker
 * @package : com.template
 * @date    : 6 déc. 2015 01:26:48
 */
public interface TemplateModel
{
    void createHtml( Map<String, Object> mapTemplateData, String ftlName, String htmlName, String directoryFtl , String versionTemplate );
}