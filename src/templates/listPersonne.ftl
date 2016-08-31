<html>
    <style type="text/css"> 
	    table#tableau tr:nth-child(even) {
	    background-color: #eee;
	    }
		table#tableau tr:nth-child(odd) {
		    background-color: #fff;
		    
		}
		table#tableau th {
		    color: white;
		    background-color: black;
		    align:center
		} 
    </style>
	<head>
	  <#if (listPerson?size >= 1)>
		<title>Liste personne!</title>
	  <#else>
		  <title>Liste personne vide!</title>
      </#if>
	</head>
	<body>
		<#if (listPerson?size >= 1)>
		<h3 align="center">${titre_liste}</h3><br/>		
		<h4>Le : ${date_du_jour!}</h4>
		<table id="tableau">
				     <tr>
					      <th width="25%">Nom</th>
					      <th width="25%">Prenom</th>
					      <th width="25%">Email</th>
					      <th width="5%">Age</th>
				     </tr>
		    	<#list listPerson as person>
		        	<tr>
		          		<td>${person.firstname}</td>
		          		<td>${person.lastname}</td>
		          		<td>${person.email}</td>
		          		<td>${person.age}</td>	 
		       		</tr>
		     	</#list>
		    </table>
		    <h4>you have ${listPerson?size} element</h4>
		<#else>
		   liste vide
		</#if>
	</body>
</html>