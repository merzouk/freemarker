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